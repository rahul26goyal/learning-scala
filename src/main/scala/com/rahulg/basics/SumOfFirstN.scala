package com.rahulg.basics

object SumOfFirstN {

  def run(num : Int): Unit = {
    var sum : Int  = 0

    for( i <- 1.to(num)) {
      sum += i
    }

    println(s"1. Sum of 1 to $num is : $sum")
    sum  = 0
    for( i <- 1.until(num+1)) {
      sum += i
    }

    println(s"2. Sum of 1 to $num is : $sum")
  }

}
