package com.rahulg.algorithms.sorting

object SortPairsExample {

  def main(args: Array[String]): Unit = {

    //var input = new Array[(Int, Int)](10)

    sortByFirstElement()

    sortBySecondElement()

  }

  def sortByFirstElement(): Unit = {
    var array: Array[(Int, Int)] = Array(
      (14,5), (12, 5), (4, 8), (10, 20), (7, 1), (10, 2),(10, 10)
    )
    var input = array.clone()
    scala.util.Sorting.quickSort(input)
    println(s"Unsorted Array: ${array.toList}")
    println(s"Sorted Array by first element: ${input.toList}")

    input = array.clone()
    scala.util.Sorting.quickSort(input)(Ordering.by[(Int, Int), Int](_._1))
    println(s"Unsorted Array: ${array.toList}")
    println(s"Sorted Array by first ele: ${input.toList}")

  }

  def sortBySecondElement(): Unit = {
    var array: Array[(Int, Int)] = Array(
      (14,5), (12, 5), (4, 8), (10, 20), (7, 1), (10, 2),(10, 10), (5, 10), (55, 10)
    )
    var input : Array[(Int, Int)] = null
    input = array.clone()
    scala.util.Sorting.quickSort(input)(Ordering.by[(Int, Int), Int](_._2))
    println(s"\nUnsorted Array: ${array.toList}")
    println(s"Sorted Array by 2nd ele: ${input.toList}")

    input = array.clone()
    scala.util.Sorting.quickSort(input)(Ordering[(Int, Int)].on(x => (x._2, x._1)))
    println(s"\nUnsorted Array: ${array.toList}")
    println(s"Sorted Array by 2nd ele than first element: ${input.toList}")

  }
}
