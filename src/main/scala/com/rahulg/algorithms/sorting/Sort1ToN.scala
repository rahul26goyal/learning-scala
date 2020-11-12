package com.rahulg.algorithms.sorting

object Sort1ToN {

  def main(args: Array[String]): Unit = {

    val input = Array(5,3,1,6,2,4)
    sortOneToN(input)
  }

  def sortOneToN(arr: Array[Int]): Unit = {
    if(arr.length == 0) {
      return
    }
    val n = arr.length
    var i = 0
    while(i < n) {
     if(i == arr(i) -1) {
        i += 1
     }
     else {
       val temp = arr(i)
       arr(i) = arr(arr(i) - 1)
       arr(arr(i) - 1) = temp
     }
    }
    println(s"Sorted: ${arr.toList}")
  }

}
