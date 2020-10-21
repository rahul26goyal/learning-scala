package com.rahulg.hackerrank.recursive

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */
object OneStepTwoStep {

  // Complete the jumpingOnClouds function below.
  // jumpingOnClouds(Array(0, 0, 0, 0, 1, 0))
  def jumpingOnClouds(c: Array[Int]): Int = {
    val size = c.length
    val start = 0
    countResursive(c, start, size)
  }

  def countResursive(c : Array[Int], start: Int, size: Int): Int = {
    if(start == size - 1)
      return 0
    if(start >= size || c(start) == 1) {
      return 999999//scala.Int.MaxValue
    }
    val l = countResursive(c, start + 1, size)
    val r = countResursive(c, start + 2, size)
    //println(s"For ${start}, l:${l}, r:${r}")
    return   scala.math.min(l, r) + 1
  }


}
