package com.rahulg.basics

object WhileImplementation {

  def run(): Unit = {

    var num: Int = 10;


    while( num > 0) {
      println(num)
      num -= 1
    }
    println("Strating the new While loop/")
    num = 5
    newWhile(num > 0) {
      println(  "Num:" + num)
      num -= 1
    }
  }

  //higher order functuon .
  //show how we can use scala to inplement our own control flows...w
  def newWhile(testCondition: => Boolean) (codeBlock: => Unit): Unit = {
    //println("here..")
    if(testCondition) {
      codeBlock
      newWhile(testCondition)(codeBlock)
    }
  }

}
