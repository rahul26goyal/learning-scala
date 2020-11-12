package com.rahulg.algorithms.search

object ExponentialSearch {

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
    if(arr.length == 0) {
      return -1
    }
    if(arr(0) == ele) {
      return 0
    }
    var start = 1
    val end = arr.length
    var prev = start
    while(start < end && arr(start) < ele) {
      prev = start
      start = 2 * start
    }

    start = math.min(start, end -1)

    BinarySearch.binarySearch(arr, prev, start, ele)

  }

}
