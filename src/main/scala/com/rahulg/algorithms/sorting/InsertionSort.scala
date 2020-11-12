package com.rahulg.algorithms.sorting

object InsertionSort {
  def main(args : Array[String]): Unit = {
    val arr = Array(5,4,3,2,1)
    println(s"Input Array to Sort: ${arr.toList}")
    insertionSort(arr)
    println(s"insertionSort  Array: ${arr.toList}")
  }

  def insertionSort(arr: Array[Int]): Unit = {
    val n = arr.length

    for(i <- 1 until n) {
      //[0..i-1] [i..n-1] are sorted and unsorted part respectively.
      val unsortedElem = arr(i) // elem to be put inside sorted array.
      var start = i -1 // end of sorted Array index
      while(start >= 0 && arr(start) > unsortedElem) {
        arr(start + 1) = arr(start)
        start = start - 1
      }
      // put the unsorted element at start + 1
      arr(start+ 1) = unsortedElem
    }
  }

}
