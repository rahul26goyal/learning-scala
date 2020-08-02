package com.rahulg.algorithms.sorting

import com.rahulg.algorithms.sorting.main.show

object QuickSort {

  def test(): Unit = {
    println(s"Testing : ${this.getClass}")
    var inputArray : Array[Int] = Array(5,4,3,2,1)
    // Array(1,2,3,4,5)
    sort(inputArray, 0, inputArray.length - 1)
    println(s"Quick Sorted array :")
    show(inputArray)
  }

  def sort(arr : Array[Int], low : Int, high: Int): Unit = {
    if(low < high) {
      val pivotIndex = getPivotIndex(arr, low, high)
      sort(arr, low, pivotIndex - 1)
      sort(arr, pivotIndex + 1, high)
    }
  }

  def getPivotIndex(arr: Array[Int], low: Int, high: Int) : Int = {
    val pivotElement = arr(high)
    var sortedIndex  = low - 1

    var i = low
    while(i < high) {
      if(arr(i) <= pivotElement) {
        sortedIndex += 1
        val temp = arr(sortedIndex)
        arr(sortedIndex) = arr(i)
        arr(i) = temp
      }
      i += 1
    }
    sortedIndex += 1
    val temp = arr(sortedIndex)
    arr(sortedIndex) = arr(high)
    arr(high) = temp
    sortedIndex
  }

}
