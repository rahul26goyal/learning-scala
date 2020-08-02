package com.rahulg.collections

case class ArratData(
                 var id: Int,
                 var name: String
               )

object ArrayExample {

  def run(): Unit = {
    //simpleExample
    objectArrayExample
  }

  def simpleExample: Unit = {
    println("Integer array::")
    val intArray = new Array[Int](5)
    show(intArray)
    intArray(0) = 1
    intArray(1) = 2
    intArray(2) = 3
    intArray(4) = 4
    show(intArray)

    println("String array::")
    val strArray = new Array[String](4)
    show(strArray)
  }

  def objectArrayExample: Unit = {
    val size = 5
    val arr : Array[ArratData] = new Array[ArratData](5)
    println("Populating ArratData into array:")
    for(i <- 1 to size) {
      arr(i-1) = ArratData(i, i.toString)
    }

    for(i <- 0 to size-1) {
      println(arr(i))
    }
  }

  def show[T](arr: Array[T]): Unit = {
    println("Printing array of size:" + arr.size)
    for(i <- arr) {
      print(i +", ")
    }
    println("")
  }
}
