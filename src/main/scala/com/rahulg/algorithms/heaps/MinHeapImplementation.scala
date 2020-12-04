package com.rahulg.algorithms.heaps


class MinHeap(val capacity: Int) {

  val heap = new Array[Int](capacity)
  var size = 0


  def insert(ele: Int): Unit = {
    if(size == capacity) {
      throw new Exception("Out of Capacity")
    }
    // insert ele at the end of tha heap
    heap(size) = ele
    size += 1
    //bubble up the last element to corrretn pos
    bubbleUp(size -1)
  }

  def getParent(i: Int): Int = {
    (i - 1) / 2
  }

  def getLeft(i: Int): Int = {
    (i*2) + 1
  }

  def getRight(i: Int): Int = {
    (i*2) + 2
  }

  def swap(i: Int, j: Int): Unit = {
    val temp = heap(i)
    heap(i) = heap(j)
    heap(j) = temp
  }
  def bubbleUp(index: Int): Unit = {
    var pos = index
    var parent = getParent(pos)
    while(parent >= 0 && heap(parent) > heap(pos)) {
      swap(parent, pos)
      pos = parent
      parent = getParent(pos)
    }
  }

  def printMin(): Unit = {
    println(s"Min So far among: ${heap.toList} is : ${heap(0)}")
  }

  // removes the min and returns it
  def pop(): Int = {
    if(size <= 0) {
      throw new Exception("Empty Heap..")
    }
    var res = heap(0)
    if(size == 1) {
      size -= 1
      return res
    }
    heap(0) = heap(size -1)
    size = size -1
    sinkDown(0)
    res
  }

  def sinkDown(index: Int): Unit = {
    var smallest = index
    val left = getLeft(index)
    val right = getRight(index)
    if(left < size && heap(left) < heap(smallest)) {
      smallest = left
    }
    if(right < size && heap(right) < heap(smallest)) {
      smallest = right
    }
    if(index != smallest) { // we still need to go down.
      swap(index, smallest)
      sinkDown(smallest)
    }
  }

}

object MinHeapImplementation {

  def main(args: Array[String]): Unit = {
    val minheap = new MinHeap(5)
    minheap.insert(5)
    minheap.insert(3)
    minheap.insert(1)
    minheap.insert(2)
    minheap.insert(1)
    //minheap.insert(1) //-> throws exception.
    minheap.printMin()
    println(s"Min: ${minheap.pop()}")
    println(s"Min: ${minheap.pop()}")
    println(s"Min: ${minheap.pop()}")
    println(s"Min: ${minheap.pop()}")
    println(s"Min: ${minheap.pop()}")
  }

}
