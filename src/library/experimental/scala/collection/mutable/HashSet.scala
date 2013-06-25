package experimental.scala.collection.mutable

import scala.collection.generic.{MutableSetFactory, CanBuildFrom}
import scala.collection.{TraversableOnce, mutable, immutable}

class HashSet[A]
  extends mutable.Set[A]
  with mutable.SetLike[A, HashSet[A]] {

  private val loadFactor = HashSet.DefaultLoadFactor

  private var table = new Array[Any](HashSet.DefaultInitialCapacity)
  private var collectionSize = 0
  private var threshold = calculateThreshold()

  override def size: Int = collectionSize

  private def calculateThreshold(): Int = (table.length * loadFactor).asInstanceOf[Int]


  private def resizeTable(newTableSize: Int) {
    val newTable = new Array[Any](newTableSize)
    foreach(putIntoTable(newTable))
    table = newTable
    threshold = calculateThreshold()
  }

  private def putIntoTable(table: Array[Any])(elem: A) {
    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => table.update(index, elem)
      case bucket: Bucket => bucket.add(elem)
      case value => table.update(index, new Bucket(value, elem))
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

  override def +=(elem: A): this.type = {
    collectionSize += 1
    if (collectionSize > threshold)
      resizeTable(table.length * 2)
    putIntoTable(table)(elem)
    this
  }

  def -=(elem: A): this.type = {
    val index = getIndex(table.length)(elem)
    table(index) match {
      case null => this
      case bucket: Bucket => {
        bucket.remove(elem) match {
          case None => this
          case Some(_) =>
            if (bucket.size == 1)
              table.update(index, bucket.getSingleValue)
            collectionSize -= 1
        }
        this
      }
      case value => {
        if (value == elem) {
          table.update(index, null)
          collectionSize -= 1
        }
        this
      }
    }
  }

  def contains(elem: A): Boolean = getCell(elem) match {
    case null => false
    case bucket: Bucket => bucket.contains(elem)
    case value => value == elem
  }

  def iterator: Iterator[A] = new Iterator[A] {
    private var index = 0
    private var bucketIterator: Iterator[A] = null
    private var elemsVisited = 0

    def hasNext: Boolean = elemsVisited < collectionSize

    def next(): A =
      if (hasNext) {
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
              case bucket: Bucket => {
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
    while (index < table.length) {
      table(index) match {
        case null => Unit
        case bucket: Bucket => bucket.foreach(f)
        case value => f(value.asInstanceOf[A])
      }
      index += 1
    }
  }

  override def empty = new HashSet[A]

  private def getIndex(tableSize: Int)(elem: A): Int = elem.hashCode & tableSize - 1

  private def getCell(elem: A): Any = table(getIndex(table.length)(elem))


  private class Bucket(val firstElem: Any, val secondElem: Any) {

    private var set: Set[A] = immutable.Set(firstElem.asInstanceOf[A], secondElem.asInstanceOf[A])

    def add(elem: A) {
      if (!set.contains(elem))
        set = set + elem
    }

    def contains(elem: A): Boolean = set.contains(elem)

    def remove(elem: A): Option[A] =
      if (set.contains(elem)) {
        set = set - elem
        Some(elem)
      } else None

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

object HashSet extends MutableSetFactory[HashSet] {

  private val DefaultInitialCapacity = 16
  private val DefaultLoadFactor = 0.75f

  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, HashSet[A]] = setCanBuildFrom[A]

  override def empty[A]: HashSet[A] = new HashSet[A]
}
