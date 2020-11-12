package com.rahulg.algorithms.search

object RecursiveLinearSearch {

  def main(args: Array[String]): Unit ={
    val input : Array[Int] = Array(1,2,3,4,5,6,7,8,9,10, 11)
    println(s"Jump Search Demo::::::${input.toList}")
    println(s"Index of 1 in ${search(input, 1)}")
    println(s"Index of 3 in ${search(input, 3)}")
    println(s"Index of 11 in ${search(input, 11)}")
    println(s"Index of 13 in ${search(input, 13)}")
    println(s"Index of 0 in ${search(input, 0)}")
  }

  def search(arr: Array[Int], ele: Int): Int = {
    recursiveSearch(arr, 0, arr.length -1, ele)
  }

  def recursiveSearch(arr: Array[Int], low: Int, high: Int, ele: Int): Int = {
    if(low <= high) {
      if(arr(low) == ele) {
        return low
      }
      if(arr(high) == ele) {
        return  high
      }
      return recursiveSearch(arr, low+1, high -1, ele)
    }
    return -1
  }

}
