package com.rahulg.algorithms.sorting

object SelectionSort {

  def main(args : Array[String]): Unit = {
    val arr = Array(5,4,3,2,1)
    println(s"Input Array to Sort: ${arr.toList}")
    selectionSort(arr)
    println(s"Sorted Array: ${arr.toList}")
  }

  def selectionSort(arr: Array[Int]): Unit = {
    val n = arr.length

    for(i<- 0 until n-1) { // [0..n-2]
      var minIndex = i
      for(j<- i+1 until n) { //[0..n-1]
        if(arr(minIndex) > arr(j)) {
          minIndex = j
        }
      }
      swap(arr, i, minIndex)
    }
  }
  def swap(arr: Array[Int], i: Int, i1: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(i1)
    arr(i1) = temp
  }
}
