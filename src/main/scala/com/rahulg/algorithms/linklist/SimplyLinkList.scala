package com.rahulg.algorithms.linklist

import scala.collection.{AbstractIterator, Iterator}

class SimplyLinkList[A] {

  var head : LNode[A] = null;

  def insertAtBeginning(data : A): Unit = {
    val node = new LNode[A](data)
    if(head == null ) {
      head = node
      return
    }
    //node.next = duplicate(head)
    node.next = head
    head = node
  }

  def duplicate(oNode : LNode[A]): LNode[A] = {
    val node = new LNode[A](oNode.data)
    node.next = oNode.next
    return node
  }

  def insertAtEnd(data: A): Unit = {
    if(head == null) {
      println("Head Null")
      head = new LNode[A](data)
      return
    }
    val node = new LNode[A](data)
    var temp = head
    while(!temp.isEnd()) {
      temp= temp.next
    }
    println("Tail at:" + temp.data)
    temp.next = node
  }

  def printL(): Unit = {
    println("Printing the Link List:")
    if(head == null) {return}
    var temp = head;
    while(temp != null) {
      print(temp.data + "--> ")
      temp = temp.next
    }
    println("NULL.")

  }

  def foreach[U](f: A => U): Unit = {
    var temp = head
    while(temp != null) {
      f(temp.data)
      temp = temp.next
    }
  }

  /**
   * Returns an Implementation of Iterator which has 2 methods.
   * @return
   */
  def iterator : Iterator[A] = new AbstractIterator[A] {
    var temp = head
    override def hasNext: Boolean = {
      temp != null
    }

    override def next(): A = {
      if(hasNext) {
        val retVal = temp.data
        temp = temp.next
        retVal
      }
      else {
        Iterator.empty.next()
      }
    }
  }

  def clear(): Unit = {
    this.head = null;
  }
}

object SimplyLinkList {

  def main(args: Array[String]): Unit = {
    val sl = new SimplyLinkList[Int]()

    printLink(s1)
  }

  def printLink(sl: SimplyLinkList[Int]): Unit = {
    for (i <- 1 to 10) {
      sl.insertAtEnd(i )
    }
    sl.printL()
    sl.clear()
    for (i <- 1 to 10) {
      sl.insertAtBeginning(i )
    }
    sl.printL()

    println("\nPrinting using the *****foreach construct***")
    sl.foreach(data => {
      print(s"${data} -->")
    })
    println()


    println("\nPrinting using the *****Iterator construct***")
    var it = sl.iterator
    while(it.hasNext) {
      print(s"${it.next()} -->")
    }
    println()
  }

  def getLinkList(): SimplyLinkList[Int] = {
    val sl = new SimplyLinkList[Int]()
    for (i <- 1 to 10) {
      sl.insertAtEnd(i )
    }
    return sl
  }
}
