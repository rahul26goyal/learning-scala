package com.rahulg.algorithms.dp

object Fibonacci {

  def main(args: Array[String]): Unit = {
    var now = System.currentTimeMillis()
    var res = fiboOfRecursive(40)
    println(s"fiboOfRecursive for 40 : ${res}")
    println(s"fiboOfRecursive Time for 40 :${System.currentTimeMillis() - now} ms")

    now = System.currentTimeMillis()
    res = fiboIterative(100)
    println(s"fiboIterative: ${res}")
    println(s"Ietrative Time:${System.currentTimeMillis() - now} ms")

    now = System.currentTimeMillis()
    res = fiboTopDown(100)
    println(s"fiboTopDown: ${res}")
    println(s"fiboTopDown Time:${System.currentTimeMillis() - now} ms")

    now = System.currentTimeMillis()
    res = fiboDP(100)
    println(s"fiboDP: ${res}")
    println(s"DP Time:${System.currentTimeMillis() - now} ms")
  }

  def fiboOfRecursive(n: Int): Long ={
    if(n == 0 || n == 1) return n.toLong
    fiboOfRecursive(n-1) + fiboOfRecursive(n-2)
  }

  def fiboTopDown(n: Int): Long = {
    val cache = new Array[Long](n +1)

    def recur(i: Int): Long = {
      if(i == 0 || i == 1) return i
      if(cache(i) != 0 ) {
        return cache(i)
      }
      cache(i) = recur(i-1) + recur(i- 2)
      cache(i)
    }

    recur(n)
    //return cache(n)
  }

  def fiboIterative(n: Int): Long = {
    if(n == 0 || n == 1) return n
    var a = 0L
    var b = 1L
    var i = 2
    var res = 0L
    while(i <= n) {
      i += 1
      res = a + b
      a = b
      b = res
    }
    res
  }

  def fiboDP(n: Int): Long = { // Bottom - Up approach
    var dp = new Array[Long](n+1)
    dp(0) = 0
    dp(1) = 1
    var i = 2
    while(i <= n) {
      dp(i) = dp(i-1) + dp(i-2)
      i += 1
    }
    dp(n)
  }
}
