package com.rahulg.algorithms.sorting

object BubbleSort {

  def main(args : Array[String]): Unit = {
    val arr = Array(5,4,3,2,1)
    println(s"Input Array to Sort: ${arr.toList}")
    bubbleSort(arr)
    println(s"Bubble Sorted Array: ${arr.toList}")
  }

  def bubbleSort(arr: Array[Int]): Unit ={
    val n = arr.length
    var ops = 0
    for(i<- 0 until n-1) { //[0..n-2]
      for(j<- 0 until n-1-i) { //[0..n-1-i]
        if(arr(j) > arr(j+1)) {
          swap(arr, j, j+1)
          ops += 1
        }
      }
    }
    //println(s"Ops: ${ops}")
  }

  def swap[A](arr: Array[A], i: Int, i1: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(i1)
    arr(i1) = temp
  }

}
