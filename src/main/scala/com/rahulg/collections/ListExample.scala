package com.rahulg.collections

class ListExample {

}

object  ListExample {

  def run(): Unit = {
    println("Running scala ListExample....")
    //simpleExample

    listOperations

  }


  def simpleExample: Unit = {
    var emptyList = List()
    println("List empty List:" + emptyList)
    var l1 = List[Int](1,2,3,4,5,6,7)
    println("Size oof the list: " + l1.size)
    println("List elements:")
    for(i <- l1) {
      print(i + ",")
    }
    println("")
    println("List: "+ l1.toString())
  }

  def listOperations: Unit = {

    // initialize list
    val l1 = List[Int](1,2,3)
     println(s"Initial list l1: $l1")
    // add elements to create a new list
    val l2 = l1 :+ 4
    println(s"appended 4 to list l1, result l2: $l2")

    val l3 = 0 +: l1
    println(s"prepended 0 to list l1, result l3: $l3")

    var l4 = l1 ++ List(5,6)
    println("adding 2 list:  l4: " + l4)

    println("Head of l4:" + l4.head)
    println("Tail of l4:" + l4.tail)
    println("Sum of elements:" + l4.sum)

  }

}
