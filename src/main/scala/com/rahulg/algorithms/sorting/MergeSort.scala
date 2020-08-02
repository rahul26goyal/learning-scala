package com.rahulg.algorithms.sorting
import com.rahulg.algorithms.sorting.main.show

object MergeSort {

  def test(): Unit = {
    println(s"Testing : ${this.getClass}")
    val inputArray : Array[Int] =  Array(7,3,1,4,5,6,5,6,6)
      // Array(1,2,3,4,5,6,7,8,9,10,11)
    sort(inputArray)
    println(s"MergeSort - Sorted array :")
    show(inputArray)
  }

  def sort(arr : Array[Int]): Unit = {
    mergeSort(arr, 0, arr.length - 1);
  }

  def mergeSort(arr: Array[Int], low: Int, high: Int): Unit = {
    if(low < high) {
      val middle = (low + high) / 2
      mergeSort(arr, low, middle)
      mergeSort(arr, middle + 1, high)
      mergeParts(arr, low, middle, high)
    }
  }

  def mergeParts(arr: Array[Int], low: Int, middle: Int, high: Int): Unit = {
    val leftLen = middle - low + 1
    val rightLen = high - middle

    val leftArr = new Array[Int](leftLen)
    val rightArr = new Array[Int](rightLen)
    var i = 0
    // backpu left side
    while(i < leftLen) {
      leftArr(i) = arr(low + i)
      i += 1
    }
    //backup right side
    i = 0
    while(i < rightLen) {
      rightArr(i) = arr(middle + 1 + i)
      i += 1
    }

    // start merging.
    var (leftIter, rightIter , arrIter) = (0, 0, low)
    while((leftIter < leftLen) && (rightIter < rightLen)) {
     if(leftArr(leftIter) <= rightArr(rightIter)) {
       arr(arrIter) = leftArr(leftIter)
       leftIter += 1
     }
     else {
       arr(arrIter) = rightArr(rightIter)
       rightIter += 1
     }
      arrIter += 1
    }

    while(leftIter < leftLen) {
      arr(arrIter) = leftArr(leftIter)
      leftIter += 1
      arrIter += 1
    }

    while(rightIter < rightLen) {
      arr(arrIter) = rightArr(rightIter)
      rightIter += 1
      arrIter += 1
    }
  }
}
