package com.rahulg.algorithms.arrays

import scala.collection.mutable

/**
 * Count the number of pairs (i, j) such that either arr[i] is divisible by arr[j] or
 * arr[j] is divisible by arr[i]
 * Ref: https://www.geeksforgeeks.org/count-the-number-of-pairs-i-j-such-that-either-arri-is-divisible-by-arrj-or-arrj-is-divisible-by-arri/?ref=rp
 */
object CountPairIJDivisible {

  def main(args: Array[String]): Unit = {
    val input = Array(3,2,4,6,2, 3)

    val count = countPairsDivisible(input)
  }

  def countPairsDivisible(array: Array[Int]): Int = {
    if(array.length== 0) {
      return 0
    }
    val max = array.max
    var count = 0
    // generate freq map
    val freqMap = new mutable.HashMap[Int, Int]()
    for(i <- 0 until array.length) {
      val value = freqMap.getOrElse(array(i), 0) + 1
      freqMap.put(array(i), value)
    }
    println(s"Freq map: ${freqMap.toList}")
    for(i <- 0 until array.length) {
      val ele = array(i)
      var j = ele * 2
      while(j <= max) {
        count += freqMap.getOrElse(j, 0)
        j += ele
      }
      if(freqMap.getOrElse(ele, 0) > 1) {
        count += freqMap.get(ele).get -1
        freqMap.update(ele, freqMap.get(ele).get -1)
      }
    }
    println(s"Count: ${count}")
    return count

  }

}
