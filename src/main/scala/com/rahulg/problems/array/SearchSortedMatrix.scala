package com.rahulg.problems.array

/**
 * Search in a row wise and column wise sorted matrix
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 */
object SearchSortedMatrix {

  def main(args: Array[String]): Unit = {
    val input = Array(
      Array(5, 7, 15, 18, 25),
      Array(7, 18, 29, 37, 63),
      Array(17, 44, 57, 77, 99)
    )

    var x = 45
    var res = checkIfExist(input, x)
    println(s"${x} exisits?:${res}")
    x = 5
    res = checkIfExist(input, x)
    println(s"${x} exisits?:${res}")

    x = 29
    res = checkIfExist(input, x)
    println(s"${x} exisits?:${res}")

    x = 500
    res = checkIfExist(input, x)
    println(s"${x} exisits?:${res}")
  }

  def checkIfExist(array: Array[Array[Int]], ele: Int): Boolean = {

    if(array.length == 0) {
      return false
    }
    val n = array.length
    val m = array(0).length
    if(ele < array(0)(0) || ele > array(n-1)(m-1)) {
      return false
    }
    // start from top right corner.
    var i = 0
    var j = m-1

    while(i < n && j >= 0) {
      if(array(i)(j) == ele) {
        println(s"Found at: ${i}, ${j}")
        return true
      }
      else if(array(i)(j) > ele) { // if greater, than number is in same row.
        j -= 1 //reduce column.
      }else { // array(i)(j) < ele  .. search in next row.
        // increase row
        i += 1
      }
    }
    println(s"Reached end at: ${i}, ${j}")
    return false
  }


}
