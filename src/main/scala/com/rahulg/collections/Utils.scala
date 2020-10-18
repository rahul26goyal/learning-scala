package com.rahulg.collections

object Utils {

  def print2DArray[A](array: Array[Array[A]]): Unit = {
    var n = array.size
    var m = array(0).size
    for(i <- 0 until  n) {
      for (j <- 0 until m) {
        print(array(i)(j) + ",")
      }
      println()
    }
  }
}
