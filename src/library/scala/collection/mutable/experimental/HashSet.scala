package scala.collection.mutable.experimental

import scala.collection.generic.{MutableSetFactory, CanBuildFrom}
import scala.collection.{TraversableOnce, mutable, immutable}
import scala.collection.mutable.experimental.HashSet.Bucket

class HashSet[A]
  extends mutable.Set[A]
  with mutable.SetLike[A, HashSet[A]] {

  private val loadFactor = HashSet.DefaultLoadFactor

  private var table = new Array[Any](HashSet.DefaultInitialCapacity)
  private var collectionSize = 0
  private var threshold = calculateThreshold()
  private var containsNull = false

  override def size: Int = collectionSize

  private def calculateThreshold(): Int = (table.length * loadFactor).asInstanceOf[Int]


  private def resizeTable(newTableSize: Int) {
    val newTable = new Array[Any](newTableSize)
    foreach(putIntoTableWithoutCheck(newTable))
    table = newTable
    threshold = calculateThreshold()
  }

  /**
   *
   * @return if the same element already existed
   */
  private def putIntoTable(table: Array[Any])(elem: A): Boolean = {
    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => {
        table.update(index, elem)
        false
      }
      case bucket: Bucket[A] => bucket.add(elem)
      case value => {
        table.update(index, HashSet.createBucket(value, elem))
        value == elem
      }
    }
  }

  /**
   * Previously existed elements replaced without any checks
   */
  private def putIntoTableWithoutCheck(table: Array[Any])(elem: A) {
    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => table.update(index, elem)
      case bucket: Bucket[A] => bucket.addWithoutCheck(elem)
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
    if (elem == null) {
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
    val newElementAdded = !putIntoTable(table)(elem)
    if (newElementAdded)
      collectionSize = expectedCollectionSize
    newElementAdded
  }

  override def remove(elem: A): Boolean = {
    if (elem == null) {
      if (containsNull) {
        containsNull = false
        collectionSize -= 1
        return true
      }
      return false
    }

    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => false
      case bucket: Bucket[A] => {
        val wasRemoved = bucket.remove(elem)
        if (wasRemoved) {
          if (bucket.size == 1)
            table.update(index, bucket.getSingleValue)
          collectionSize -= 1
        }
        wasRemoved
      }
      case value => {
        val sameElem = value == elem
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
    if (elem == null)
      containsNull
    else
      getCell(elem) match {
        case null => false
        case bucket: Bucket[A] => bucket.contains(elem)
        case value => value == elem
      }
  }

  def iterator: Iterator[A] = new Iterator[A] {
    private var index = -1
    private var bucketIterator: Iterator[A] = null
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
          elem
        } else {
          while (index < table.length) {
            table(index) match {
              case null => index += 1
              case bucket: Bucket[A] => {
                bucketIterator = bucket.iterator
                elemsVisited += 1
                return bucketIterator.next()
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
        case bucket: Bucket[A] => bucket.foreach(f)
        case value => f(value.asInstanceOf[A])
      }
      index += 1
    }
  }

  override def empty = new HashSet[A]

  private def getIndex(tableSize: Int)(elem: A): Int = elem.## & tableSize - 1

  private def getCell(elem: A): Any = table(getIndex(table.length)(elem))
}

object HashSet extends MutableSetFactory[HashSet] {

  private val DefaultInitialCapacity = 16
  private val DefaultLoadFactor = 0.75f

  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, HashSet[A]] = setCanBuildFrom[A]

  override def empty[A]: HashSet[A] = new HashSet[A]

  private def createBucket[A](firstElem: Any, secondElem: Any): Bucket[A] = {
    new Bucket[A](immutable.Set(firstElem.asInstanceOf[A], secondElem.asInstanceOf[A]))
  }

  private class Bucket[A](var set: Set[A]) {

    /**
     * @return if the same element already existed
     */
    def add(elem: A): Boolean = {
      val elementAlreadyExisted = set.contains(elem)
      set = set + elem
      elementAlreadyExisted
    }

    def addWithoutCheck(elem: A) {
      set = set + elem
    }

    def contains(elem: A): Boolean = set.contains(elem)

    def remove(elem: A): Boolean = {
      val alreadyExisted = set.contains(elem)
      if (alreadyExisted)
        set = set - elem
      alreadyExisted
    }

    def getSingleValue: A =
      if (size == 1)
        set.head
      else throw new IllegalStateException("trying to get single value from bucket with size " + size)

    def size: Int = set.size

    def iterator: Iterator[A] = set.iterator

    def foreach[U](f: A => U) {
      set.foreach(f)
    }
  }

}
