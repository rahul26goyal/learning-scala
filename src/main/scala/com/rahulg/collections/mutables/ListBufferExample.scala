package com.rahulg.collections.mutables

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
object ListBufferExample {

  def main(args: Array[String]): Unit = {

    var listBuffer = new ListBuffer[Int]() // create LB if size 0

    populateListBuffer(listBuffer)

    printBuffer(listBuffer)
  }

  def populateListBuffer(lb: ListBuffer[Int]): Unit = {
    lb.append(1)
    lb.append(2)
    lb.append(3)
    lb.prepend(0)
  }

  def printBuffer(ints: ListBuffer[Int]): Unit = {
    println()
    //var s = scala.collection.mutable.Sta
    ints.foreach(ele => {
      print(s"${ele} --> ")
    })
    println()
  }

}
