package com.rahulg.basics

object EvenOdd {

  def run(num : Int): Unit = {

    val rem = num % 2;
    var res : String = ""
    if(rem == 0 ) {
      res = "Even"
    }
    else {
      res = "Odd"
    }
    println(s"Number : $num is $res")

    res = if (res == 0) "Even" else "Odd"

    println(s"Res2: Number : $num is $res")

  }

}
