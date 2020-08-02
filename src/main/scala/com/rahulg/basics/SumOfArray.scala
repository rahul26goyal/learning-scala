package com.rahulg.basics

object SumOfArray {

  def run(): Unit = {
    //val arr : Array[Int] = Array[Int](1,2,3,4,5,6,7,8,9)
    //var x = List(1,2,3)
    val arr = Array[Int](1,2,3,4,5,6,7,8,9)
    var sum = 0;
    for(i <- arr) {
      print(i + " ")
      sum += i
    }

    println(s"\nSum of the all number of array: $sum")

    var evenSum = 0
    //for loop can also do inline filtering.
    for(i <- arr; if ((i%2== 0))) {
      print(i + " ")
      evenSum += i
    }

    println(s"\nSum of the Even number of array: $evenSum")
  }

}
