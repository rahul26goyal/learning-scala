package com.rahulg.algorithms.sorting

import com.rahulg.algorithms.sorting.main.show

object HeapSort {

  def test(): Unit = {
    println(s"Testing : ${this.getClass}")
    val inputArray : Array[Int] =  Array(1,2,3,4,5,6,7,8,9,10,11)
      // Array(5,4,3,2,1)
    sort(inputArray)
    println(s"HeapSort - Sorted array :")
    show(inputArray)
  }

  /**
   * Used MAx Heap to Sort the elements on the given array.
   * @param arr
   */
  def sort(arr : Array[Int]): Unit = {
    buildMaxHeapFromArray(arr)
    println("Built Max heap:")
    show(arr)
    println()
    var iter = arr.length -1
    while(iter > 0) {
      // swap the first with the last
      val temp = arr(0)
      arr(0) = arr(iter)
      arr(iter) = temp
      // heapify from rootIndex 0
      heapify(arr, iter, 0)
      iter -= 1
      // show(arr)
    }

  }

  def buildMaxHeapFromArray(arr : Array[Int]): Unit = {
    val size = arr.length
    var lastParentIndex : Int = ((size/2) - 1).toInt
    // create a max heap out of the array, starting at the last parent.
    while(lastParentIndex >= 0) {
      heapify(arr, size, lastParentIndex)
      lastParentIndex -= 1
    }
  }

  /**
   * Heapify / sinkdown the maxHeap from rootIndex.
   * @param arr
   * @param size
   * @param rootIndex
   */
  def heapify(arr: Array[Int], size: Int, rootIndex: Int): Unit = {
    val parent = rootIndex
    val left = parent * 2 + 1
    val right = parent * 2 + 2
    var maxIndex = rootIndex
    if(left < size && arr(left) > arr(maxIndex)) {
      maxIndex = left
    }

    if(right < size && arr(right) > arr(maxIndex)) {
      maxIndex = right
    }

    if(maxIndex != rootIndex) {
      // need to change the elements and heapify
      val temp = arr(rootIndex)
      arr(rootIndex) = arr(maxIndex)
      arr(maxIndex) = temp
      heapify(arr, size, maxIndex)
    }
  }

}
