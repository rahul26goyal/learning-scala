package com.rahulg.algorithms.search

/**
 * Find last occurance of a ele in an sorted repeated array
 * (1,2,2,3,3,3,4,4,4,5,5)
 *
 * f(1)= 0
 * f(3) = 5
 *
 */
object FindLastOccurance {

  def main(args: Array[String]): Unit = {
    val input = Array(1,2,2,3,3,3,4,4,4,5,5)
    println(s"Input: ${input}")
    println(s"LAst Index of 1 is ${findLastOccurance(input, 0, input.length-1, 1)}")
    println(s"LAst Index of 2 is ${findLastOccurance(input, 0, input.length-1, 2)}")
    println(s"LAst Index of 5 is ${findLastOccurance(input, 0, input.length-1, 5)}")

    println(s"\nInput: ${input.toList}")
    println(s"findFirstOccurance Index of 1 is ${findFirstOccurance(input, 0, input.length-1, 1)}")
    println(s"findFirstOccurance Index of 2 is ${findFirstOccurance(input, 0, input.length-1, 2)}")
    println(s"findFirstOccurance Index of 5 is ${findFirstOccurance(input, 0, input.length-1, 5)}")

  }

  def findLastOccurance(arr: Array[Int], low: Int, hig: Int, ele: Int): Int = {
    if(low <= hig) {
      val mid : Int = (low + hig) / 2

      if(arr(mid) > ele) {
        return findLastOccurance(arr, low,mid-1, ele)
      }
      else if(arr(mid) < ele) {
        return findLastOccurance(arr, mid+1, hig, ele)
      }
      else {
        if(mid == hig || arr(mid+1) != arr(mid)) {
          return mid
        }
        return findLastOccurance(arr, mid+1, hig, ele)
      }
    }
    return -1
  }

  def findFirstOccurance(arr: Array[Int], low: Int, hig: Int, ele: Int): Int = {
    if(low <= hig) {
      val mid : Int = (low + hig) / 2

      if(arr(mid) > ele) {
        return findFirstOccurance(arr, low,mid-1, ele)
      }
      else if(arr(mid) < ele) {
        return findFirstOccurance(arr, mid+1, hig, ele)
      }
      else { // ele is equal to mid
        if(mid == 0 || arr(mid-1) != arr(mid)) {
          return mid
        }
        return findFirstOccurance(arr, low, mid-1, ele)
      }
    }
    return -1
  }

}
