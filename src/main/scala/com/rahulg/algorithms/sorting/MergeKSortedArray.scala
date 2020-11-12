package com.rahulg.algorithms.sorting

/**
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-3-using-divide-and-conquer-approach/
 *
 * Input: arr[][] = {{5, 7, 15, 18},
 * {1, 8, 9, 17},
 * {1, 4, 7, 7}}
 * Output: {1, 1, 4, 5, 7, 7, 7, 8, 9, 15, 17, 18}
 */
object MergeKSortedArray {

  def main(args: Array[String]): Unit = {
    val input = Array(
      Array(5, 7, 15, 18, 25),
      Array(1, 8, 9, 17, 23),
      Array(1, 4, 7, 7, 9)
    )
    val sortedArray = new Array[Int](input.length * input(0).length)

    mergeKSortedArray(input,sortedArray, 0, input.length - 1)
    println(s"Sroted Array: ${sortedArray.toList}")
  }

  def mergeKSortedArray(array: Array[Array[Int]], sortedArray: Array[Int], left: Int, right: Int): Unit = {

    if(left < right) {
      val mid = (left + right) / 2
      mergeKSortedArray(array, sortedArray, left, mid)
      mergeKSortedArray(array, sortedArray, mid+1, right)
      val colLen = array(0).length
      mergeParts(sortedArray, left, mid, right, colLen)
    }
    // this step is not present in merge sort because the original array and output array is the same.
    if(left == right) {
      val colLength = array(0).length
      var startIndex = left * colLength
      for(i <- 0 until colLength) {
        sortedArray(startIndex + i) = array(left)(i)
      }
      println(s"Sorted Array populated (${left}): ${sortedArray.toList}")
    }
  }

  def mergeParts(sortedArray: Array[Int], left: Int, mid: Int, right: Int, colLen : Int): Unit = {

    val leftIndex = left * colLen
    val rightIndex = (mid + 1) * colLen

    val leftSize = (mid - left + 1) * colLen
    val leftArray = new Array[Int](leftSize)

    val rightSize = (right - mid) * colLen
    val rightArray = new Array[Int](rightSize)

    for(i <- 0 until leftSize) {
      leftArray(i) = sortedArray(leftIndex + i)
    }

    for(j <- 0 until rightSize) {
      rightArray(j) = sortedArray(rightIndex + j)
    }

    var i = 0
    var j = 0
    var it = leftIndex

    while(i < leftSize && j < rightSize) {
      if(leftArray(i) < rightArray(j)) {
        sortedArray(it) = leftArray(i)
        i += 1
      }
      else {
        sortedArray(it) = rightArray(j)
        j += 1
      }
      it += 1
    }
    while(i < leftSize) {
      sortedArray(it) = leftArray(i)
      i += 1
      it += 1
    }

    while(j < rightSize) {
      sortedArray(it) = rightArray(j)
      j += 1
      it += 1
    }
  }


}
