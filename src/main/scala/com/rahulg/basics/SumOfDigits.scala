package com.rahulg.basics

object SumOfDigits {

  def run(n: Int): Unit = {

    var sum : Int = 0;
    var num = n;
    while(num != 0) {
      println(s"Number: $num")
      sum += (num %10)
      num = num / 10
    }

    println(s"The sum of digits of $n = $sum")

  }

}
