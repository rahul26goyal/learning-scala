package com.rahulg.algorithms.search

object LinearSearch {

  def main(args: Array[String]): Unit ={
    val input : Array[Int] = Array(1,2,3,4,5,6)

    println(s"Index of 3 in ${search(input, 3)}")
    println(s"Index of 13 in ${search(input, 13)}")
  }

  def search(arr: Array[Int], ele: Int): Int = {
    for(i <- 0 until arr.length) {
      if(arr(i) == ele) {
        return i
      }
    }
    return -1
  }


}
