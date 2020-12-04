package com.rahulg.collections.mutables

import scala.collection.mutable


object PerityQueueWithPersonObject {

  def main(args: Array[String]): Unit = {

    testPersonMaxHeap()
    testPersonMinHeap()
  }

  def testPersonMaxHeap(): Unit = {
    // default is a maxheap..
    val maxHeap = new mutable.PriorityQueue[Person]()(PersonMaxOrdering)
    var inputs = Array(Person("a", 10), Person("b", 5), Person("c", 15),
      Person("d", 12)
    )
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

  def testPersonMinHeap(): Unit = {

    val MinHeap = new mutable.PriorityQueue[Person]()(PersonMinOrdering)
    var inputs = Array(Person("a", 10), Person("b", 5), Person("c", 15),
      Person("d", 12)
    )
    for (elem <- inputs) {
      MinHeap.enqueue(elem)
    }
    println(s"\n\nMinheap: ${MinHeap}")
    print("Dequeue one by one: ")
    while(MinHeap.size != 0) {
      print(s"${MinHeap.dequeue()}, ")
    }
    println()
  }

}

case class Person(name: String, age: Int) {
  def compare(y : Person): Int = {
    if(this.age < y.age) return -1
    if(this.age == y.age) return 0
    1
  }
}

object PersonMinOrdering extends Ordering[Person] {
  override def compare(x: Person, y: Person): Int = {
    y compare x
  }
}

object PersonMaxOrdering extends Ordering[Person] {
  override def compare(x: Person, y: Person): Int = {
    x compare y
  }
}