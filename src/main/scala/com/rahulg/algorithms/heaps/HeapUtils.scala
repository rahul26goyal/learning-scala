package com.rahulg.algorithms.heaps

import  com.rahulg.algorithms.heaps.main.show
object HeapUtils {

  def convertArrayToMaxHeap(arr : Array[Int]): Unit = {
    val size = arr.size
    val lastParentIndex = (size/2) - 1
    var i = lastParentIndex
    while(i >=0) {
      sinkDownTheMaxHeap(arr, size, i);
      i -= 1
    }
  }

  def sinkDownTheMaxHeap(heap: Array[Int], size: Int, rootIndex: Int): Unit = {
    val leftChildIndex = rootIndex * 2 + 1
    val rightChildIndex = rootIndex * 2 + 2
    var largeIndex = rootIndex
    if(leftChildIndex < size && heap(largeIndex) < heap(leftChildIndex)) {
      largeIndex = leftChildIndex
    }
    if(rightChildIndex < size && heap(largeIndex) < heap(rightChildIndex)) {
      largeIndex = rightChildIndex
    }
    if(largeIndex != rootIndex) {
      swap(heap, rootIndex, largeIndex)
      sinkDownTheMaxHeap(heap, size, largeIndex)
    }
  }

  def test(): Unit = {
    val inputArray : Array[Int] = Array(1,2,3,4,5,6,7)
      // Array(10,23,4,67,8,67)
    convertArrayToMaxHeap_approach2(inputArray)
    // convertArrayToMaxHeap(inputArray)
    show(inputArray)
    println(s"checkIfArrayMaxHeap: ${checkIfArrayMaxHeap(inputArray)}")
    // assert(inputArray.eq((1,2,3,4,5)), "did not match")
  }
  def convertArrayToMaxHeap_approach2(arr : Array[Int]): Unit = {
    // arr = (1,2,3,4,5)
    var i = 1;
    // assume that we start witth a max heap of size =1
    while(i < arr.length) {
      // keep increasing the size of the max heap as we inerate though the array
      bubbleUpMaxHeap(arr, i+1, i)
      i += 1
      show(arr)
    }
    println("end")
  }
  def bubbleUpMaxHeap(arr: Array[Int], size: Int, startIndex: Int): Unit = {
    var pos = startIndex
    var parent = (pos -1)/2
    while(parent >= 0 && arr(parent) < arr(pos)) {
      swap(arr, parent, pos)
      pos = parent
      parent = (pos-1)/2
    }
  }

  def swap(ints: Array[Int], i: Int, i1: Int): Unit = {
    val temp = ints(i)
    ints(i) = ints(i1)
    ints(i1) = temp
  }

  def checkIfArrayMaxHeap(heap : Array[Int]): Boolean = {
    val res : Boolean = isMaxHeap(heap, heap.length, 0)
    res
  }

  /**
   * Checks if the heap rooted at Index `rootIndex` is a MaxHeap.
   * @param heap
   * @param size
   * @param rootIndex
   */
  def isMaxHeap(heap : Array[Int], size : Int, rootIndex : Int): Boolean = {
    val lastParentIndex = (size-2)/2
    if(rootIndex > lastParentIndex) {
      return true
    }
    val li = rootIndex * 2 + 1
    val ri = rootIndex * 2 + 2
    if(li < size && ri < size && heap(li) < heap(rootIndex) && heap(ri) < heap(rootIndex)) {
      return (isMaxHeap(heap, size, li) && isMaxHeap(heap, size, ri))
    }
    false
  }


  def convertArrayToMinHeap(arr : Array[Int]): Unit = {

  }
}
