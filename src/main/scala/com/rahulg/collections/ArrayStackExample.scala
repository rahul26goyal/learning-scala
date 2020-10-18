package com.rahulg.collections

import scala.collection.mutable

object ArrayStackExample {

  def main(args: Array[String]): Unit = {

    var arrStack = new mutable.ArrayStack[Int]();

    insertValues(arrStack);

    printValues(arrStack)

    printValuesInArrayOrder(arrStack)

    drainStack(arrStack)
  }

  def insertValues(arrStack: mutable.ArrayStack[Int]): Unit = {
    arrStack.push(1)
    arrStack.push(2)
    arrStack.push(3)
    arrStack.push(4)
    println(s"Size : ${arrStack.length}")
  }

  def printValues(arrStack: mutable.ArrayStack[Int]): Unit = {
    println("Print using ********for loop**************LIFO Order.")
    // prints in the stack order.. LIFO.
    for (elem <- arrStack) {
      print(s"$elem , ")
    }
    println("\n using *******foreach**********LIFO Order")
    arrStack.foreach(elem => {
      print(s"$elem , ")
    })
    println()
  }

  def printValuesInArrayOrder(arrStack: mutable.ArrayStack[Int]): Unit = {
    val size = arrStack.size
    var i = 0
    println("Prinign the elements ******using apply(index)******")
    while(i < size) {
      print(s"${arrStack.apply(i)}, ")
      i += 1;
    }
    println()

    i = size -1
    println("Printing in FIFO Order.....")
    while(i >= 0) {
      print(s"${arrStack.apply(i)}, ")
      i -= 1;
    }
    println()
  }

  def drainStack(arrStack: mutable.ArrayStack[Int]): Unit = {
    println("Draining the Stack...")
    while(!arrStack.isEmpty) {
      print(s"${arrStack.top}, ")
      arrStack.pop()
    }
    println()
  }



}
