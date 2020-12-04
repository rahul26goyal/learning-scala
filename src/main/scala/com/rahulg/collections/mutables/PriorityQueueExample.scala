package com.rahulg.collections.mutables

import scala.collection.mutable

object PriorityQueueExample {

  def main(args: Array[String]): Unit = {

    simpleDefaultPQ()
  }

  def simpleDefaultPQ(): Unit = {
    // default is a maxheap..
    val maxHeap = new mutable.PriorityQueue[Int]()
    var inputs = Array(5,4,1,2,10)
    for (elem <- inputs) {
      maxHeap.enqueue(elem)
    }
    println(s"Maxheap: ${maxHeap}")
    print("Dequeue one by one: ")
    while(maxHeap.size != 0) {
      print(s"${maxHeap.dequeue()}, ")
    }
    println()
  }

  def intMaxHeapPQ(): Unit = {
    // default is a maxheap..
    val maxHeap = new mutable.PriorityQueue[Int]()
    var inputs = Array(5,4,1,2,10)
    for (elem <- inputs) {
      maxHeap.enqueue(elem)
    }
    println(s"Maxheap: ${maxHeap}")
    print("Dequeue one by one: ")
    while(maxHeap.size != 0) {
      print(s"${maxHeap.dequeue()}, ")
    }
    println()
  }
}
