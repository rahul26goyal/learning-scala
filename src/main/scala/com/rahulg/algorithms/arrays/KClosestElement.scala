package com.rahulg.algorithms.arrays

object KClosestElement {

  def main(args: Array[String]): Unit = {
    val input = Array(10, 20, 33, 35, 39, 42, 48, 50)

    findKClosestInSortedArray(input, 35, 4)
  }

  def findKClosestInSortedArray(arr: Array[Int], elem: Int, k: Int): Unit = {

    if(arr.length == 0 || k == 0) {
      return
    }
    val elemIndex = getElemIndex(arr, 0 , arr.length -1, elem)
  }

  def getElemIndex(arr: Array[Int], low: Int, high: Int, elem: Int): Int = {
    if(arr(high) <= elem) {
      return high
    }
    if(arr(low) > elem) {
      return low
    }
    val mid = (low + high) / 2
    if(arr(mid) == elem) {
      if(arr(mid +1) != elem) {
        return mid
      }
    }
    else if(arr(mid) < elem) {
      return getElemIndex(arr, mid-1,high,  elem)
    }
    return getElemIndex(arr, low, mid-1,  elem)
  }

}
