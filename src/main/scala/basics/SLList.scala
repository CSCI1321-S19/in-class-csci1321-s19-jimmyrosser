package basics

import collection.mutable

class SLList[A] extends mutable.Buffer[A] {
  private var hd: Node = null
  private var tl: Node = null
  private var numElems = 0
  private class Node(var data: A, var next: Node)
  def +=(elem: A): this.type = {
    val n = new Node(elem, null)
    if (head == null) {
      hd = n
    } else {
      tl.next = n
    }
    numElems += 1
    tl = n
    this
  }
  def +=:(elem: A): this.type = {
    ???
  }
  def apply(n: Int): A = {
    var rover = hd
    for (_ <- 1 to n) rover = rover.next
    rover.data
  }
  def clear(): Unit = {
    hd = null
    tl = null
    numElems = 0
  }
  def insertAll(n: Int, elems: Traversable[A]): Unit = {

  }
  def length: Int = {
    numElems
  }
  def remove(n: Int): A = {
    numElems -= 1
    if (n == 0) {
      val ret = hd.data
      hd=hd.next
      if(hd==null) tl = null
      ret
    } else {
      var rover = hd
      for (_ <- 1 to n - 1) rover = rover.next
      if(rover.next==tl) tl = rover
      val ret = rover.next.data
      rover.next = rover.next.next
      ret
    }
  }
  def update(n: Int, newelem: A): Unit = {
    var rover = hd
    for (_ <- 1 to n) rover = rover.next
    rover.data = newelem
  }

  //Members declared in scala.collection.IterableLike
  def iterator = new Iterator[A] {
    var rover = hd
    def hasNext: Boolean = rover != null
    def next(): A = {
      val ret = rover.data
      rover = rover.next
      ret
    }
  }
}

//while(rover != null) {
//  val d = rover.data
//  //do stuff with d
//  rover=rover.next
//}
//
//var i
//while(i < a.length) {
//  val d = a(i)
//  //do stuff with d
//  i += 1
//}