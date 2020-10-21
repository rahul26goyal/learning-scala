package com.rahulg.hackerrank.array

import scala.collection.mutable

object SalesByMatch {

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    val map = new mutable.HashMap[Int, Int]()
    for (i <- 0 until n) {
      val ele = ar(i)
      val value = map.get(ele)
      if (value == None) {
        map.put(ele, 1)
      }
      else {
        map.put(ele, value.get + 1)
      }
    }
    var result: Int = 0
    val it = map.iterator
    while (it.hasNext) {
      result += (it.next._2 / 2).toInt
    }
    //println(s"Result: ${result}")
    result
  }

}
