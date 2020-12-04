package com.rahulg.collections

object ArrayAdhoc {

  def main(args: Array[String]): Unit = {
    testArray()
  }

  def testArray(): Unit = {

    var arr = Array(1,2,3,4)
    for(i <- 0 until arr.length) {
      println(arr(i))
    }
    arr.sorted
  }

}
