package com.rahulg.basics

object UsingExpressions {

  def run(): Unit = {

    var input = Seq(1,2,3,4,5)

    var result = for(i <- input) {
      i * i
    }

    println(s"1. Input: $input result: $result") // result here in Unit

    var result2 = for{i <- input} yield { //using for loop as expression.
      i * i
    }

    println(s"2. Input: $input , result: $result2")

  }

}
