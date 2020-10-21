package com.rahulg.hackerrank.strings

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 */
class RepeatedString {

  // repeatedString("aba", 10) => 7 a's
  def repeatedString(s: String, n: Long): Long = {
    val len = s.length
    val ch = 'a'
    var fullCountA = 0 // Number of a's in goven string
    var tail : Long = n % len // last subset.
    var tailCountA = 0

    for(i <- 0 until len) {
      if(s(i) == ch) {
        fullCountA += 1
      }
      if(i+1 == tail) {
        tailCountA = fullCountA
      }
    }

    //println(s"fullCountA: ${fullCountA}, tailCountA: ${tailCountA}")
    var result: Long = (fullCountA.toLong * (n /len).toLong + tailCountA.toLong).toLong
    result
  }

}
