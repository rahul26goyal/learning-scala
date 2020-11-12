package com.rahulg.algorithms.search

object BinarySearch {

  def main(args: Array[String]): Unit ={
    val input : Array[Int] = Array(1,2,3,4,5,6)
    println(s"Binary Search Demo::::::${input.toList}")
    println(s"Index of 3 in ${search(input, 1)}")
    println(s"Index of 3 in ${search(input, 3)}")
    println(s"Index of 3 in ${search(input, 6)}")
    println(s"Index of 13 in ${search(input, 13)}")
    println(s"Index of 13 in ${search(input, 0)}")
  }

  def search(arr: Array[Int], ele: Int): Int = {
    binarySearch(arr, 0, arr.length -1, ele)
  }

  def binarySearch(arr: Array[Int], low: Int, high: Int, ele: Int): Int = {
    if(low <= high) {
      val mid : Int = (low+ high) / 2

      if(arr(mid) == ele) {
        return mid
      }
      if(arr(mid) > ele) {
        return binarySearch(arr, low, mid -1, ele)
      }
      return binarySearch(arr, mid +1, high, ele)
    }
    return -1
  }

}
