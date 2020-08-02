package com.rahulg.basics

object StringInterpolation {

  def run(): Unit = {

    val name : String = "Rahul Goyal"
    val age  = 19.6
    val staus : String = "Married"
    val dob  : String = "28th Jan 2019"

    //not type safe
    val details1 = s"My name is $name. I am $age years old. I am $staus. My DOb: $dob"
    println(details1)
    //type safe
    val details2 = f"My name is $name%s. I am $age%f years old. I am $staus%s. My DOb: $dob%s"
    println(details2)

  }

}
