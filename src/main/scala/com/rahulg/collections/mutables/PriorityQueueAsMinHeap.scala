package com.rahulg.collections.mutables

import scala.collection.mutable

object PriorityQueueAsMinHeap {

  object MinOrdering extends Ordering[Int] {
    //override def compare(x: Int, y: Int): Int = y compare x
    override def compare(x: Int, y: Int): Int = {
      if(y < x) return -1
      if(y == x) return 0
      1
    }
  }

  def main(args: Array[String]): Unit = {
    initMinHeapPQ
  }

  def initMinHeapPQ(): Unit = {
    // default is a maxheap..
    //val minHeap = mutable.PriorityQueue.empty[Int](MinOrdering)
    val minHeap = new mutable.PriorityQueue[Int]()(MinOrdering)
    //val minHeap = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
    var inputs = Array(5,4,1,2,10)
    for (elem <- inputs) {
      minHeap.enqueue(elem)
    }
    println(s"Minheap: ${minHeap}")
    print(s"Dequeue one by one: Head: ${minHeap.head}\n")
    while(minHeap.size != 0) {
      print(s"${minHeap.dequeue()}, ")
    }
    println()
  }
}
