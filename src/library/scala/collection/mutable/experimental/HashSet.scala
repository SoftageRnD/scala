package scala.collection.mutable.experimental

import scala.collection.generic.{MutableSetFactory, CanBuildFrom}
import scala.collection.{TraversableOnce, mutable, immutable}
import scala.collection.mutable.experimental.HashSet.Bucket

class HashSet[A]
  extends mutable.Set[A]
  with mutable.SetLike[A, HashSet[A]] {

  private val loadFactor = HashSet.DefaultLoadFactor

  private var table = new Array[AnyRef](HashSet.DefaultInitialCapacity)
  private var collectionSize = 0
  private var threshold = calculateThreshold()
  private var containsNull = false

  override def size: Int = collectionSize

  private def calculateThreshold(): Int = (table.length * loadFactor).asInstanceOf[Int]


  private def resizeTable(newTableSize: Int) {
    val newTable = new Array[AnyRef](newTableSize)
    var index = 0
    while (index < newTableSize) {
      newTable(index) match {
        case null => Unit
        case bucket: Bucket => bucket.foreach(putIntoTableWithoutCheck(newTable))
        case value => putIntoTableWithoutCheck(newTable)(value)
      }
      index += 1
    }
    table = newTable
    threshold = calculateThreshold()
  }

  /**
   *
   * @return if the same element already existed
   */
  private def putIntoTable(table: Array[AnyRef])(elem: AnyRef): Boolean = {
    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => {
        table.update(index, elem)
        false
      }
      case bucket: Bucket => bucket.add(elem)
      case value => {
        val isSame = value == elem
        if (!isSame)
          table.update(index, HashSet.createBucket(value, elem))
        isSame
      }
    }
  }

  /**
   * Previously existed elements replaced without any checks
   */
  private def putIntoTableWithoutCheck(table: Array[AnyRef])(elem: AnyRef) {
    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => table.update(index, elem)
      case bucket: Bucket => bucket.addWithoutCheck(elem)
      case value => table.update(index, HashSet.createBucket(value, elem))
    }
  }

  override def ++=(xs: TraversableOnce[A]): this.type = {
    // java.util.HashMap.putAll
    val numOfElementsToAdd = xs.size
    if (numOfElementsToAdd > threshold) {
      val predictedCapacity: Int = (numOfElementsToAdd / loadFactor + 1).asInstanceOf[Int]
      var newCapacity: Int = table.length
      while (newCapacity < predictedCapacity)
        newCapacity <<= 1
      if (newCapacity > table.length)
        resizeTable(newCapacity)
    }
    super.++=(xs)
  }

  override def add(elem: A): Boolean = {
    val elemRef = elem.asInstanceOf[AnyRef]
    if (elemRef eq null) {
      if (!containsNull) {
        containsNull = true
        collectionSize += 1
        return true
      }
      return false
    }

    val expectedCollectionSize = collectionSize + 1
    if (expectedCollectionSize > threshold)
      resizeTable(table.length * 2)
    val newElementAdded = !putIntoTable(table)(elemRef)
    if (newElementAdded)
      collectionSize = expectedCollectionSize
    newElementAdded
  }

  override def remove(elem: A): Boolean = {
    val elemRef = elem.asInstanceOf[AnyRef]
    if (elemRef eq null) {
      if (containsNull) {
        containsNull = false
        collectionSize -= 1
        return true
      }
      return false
    }

    val index = getIndex(table.length)(elemRef)
    table(index) match {
      case null => false
      case bucket: Bucket => {
        val wasRemoved = bucket.remove(elemRef)
        if (wasRemoved) {
          if (bucket.size == 1)
            table.update(index, bucket.getSingleValue)
          collectionSize -= 1
        }
        wasRemoved
      }
      case value => {
        val sameElem = value == elemRef
        if (sameElem) {
          table.update(index, null)
          collectionSize -= 1
        }
        sameElem
      }
    }
  }

  override def +=(elem: A): this.type = {
    add(elem)
    this
  }

  def -=(elem: A): this.type = {
    remove(elem)
    this
  }

  def contains(elem: A): Boolean = {
    val elemRef = elem.asInstanceOf[AnyRef]
    if (elemRef eq null)
      containsNull
    else
      getCell(elemRef) match {
        case null => false
        case bucket: Bucket => bucket.contains(elemRef)
        case value => value == elemRef
      }
  }

  def iterator: Iterator[A] = new Iterator[A] {
    private var index = -1
    private var bucketIterator: Iterator[AnyRef] = null
    private var elemsVisited = 0

    def hasNext: Boolean = elemsVisited < collectionSize

    def next(): A =
      if (hasNext) {
        if (index == -1) {
          index = 0
          if (containsNull) {
            elemsVisited += 1
            return null.asInstanceOf[A]
          }
        }

        if (bucketIterator != null) {
          val elem = bucketIterator.next()
          if (!bucketIterator.hasNext) {
            bucketIterator = null
            index += 1
          }
          elemsVisited += 1
          elem.asInstanceOf[A]
        } else {
          while (index < table.length) {
            table(index) match {
              case null => index += 1
              case bucket: Bucket => {
                bucketIterator = bucket.iterator
                elemsVisited += 1
                return bucketIterator.next().asInstanceOf[A]
              }
              case value => {
                elemsVisited += 1
                index += 1
                return value.asInstanceOf[A]
              }
            }
          }
          throw new IllegalStateException("next element supposed to be but not found")
        }
      } else throw new IllegalStateException("no next element for the iterator")
  }

  override def foreach[U](f: A => U) {
    var index = 0
    if (containsNull)
      f(null.asInstanceOf[A])
    while (index < table.length) {
      table(index) match {
        case null => Unit
        case bucket: Bucket => bucket.foreach((el: AnyRef) => f(el.asInstanceOf[A]))
        case value => f(value.asInstanceOf[A])
      }
      index += 1
    }
  }

  override def empty = new HashSet[A]

  private def getIndex(tableSize: Int)(elem: AnyRef): Int = elem.## & tableSize - 1

  private def getCell(elem: AnyRef): Any = table(getIndex(table.length)(elem))
}

object HashSet extends MutableSetFactory[HashSet] {

  private val DefaultInitialCapacity = 16
  private val DefaultLoadFactor = 0.75f

  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, HashSet[A]] = setCanBuildFrom[A]

  override def empty[A]: HashSet[A] = new HashSet[A]

  private def createBucket[A](firstElem: AnyRef, secondElem: AnyRef): Bucket = {
    new Bucket(immutable.Set(firstElem, secondElem))
  }

  private class Bucket(var set: Set[AnyRef]) {

    /**
     * @return if the same element already existed
     */
    def add(elem: AnyRef): Boolean = {
      val elementAlreadyExisted = set.contains(elem)
      set = set + elem
      elementAlreadyExisted
    }

    def addWithoutCheck(elem: AnyRef) {
      set = set + elem
    }

    def contains(elem: AnyRef): Boolean = set.contains(elem)

    def remove(elem: AnyRef): Boolean = {
      val alreadyExisted = set.contains(elem)
      if (alreadyExisted)
        set = set - elem
      alreadyExisted
    }

    def getSingleValue: AnyRef =
      if (size == 1)
        set.head
      else throw new IllegalStateException("trying to get single value from bucket with size " + size)

    def size: Int = set.size

    def iterator: Iterator[AnyRef] = set.iterator

    def foreach[U](f: AnyRef => U) {
      set.foreach(f)
    }
  }

}
