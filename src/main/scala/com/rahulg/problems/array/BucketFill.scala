package com.rahulg.problems.array
import  com.rahulg.collections.Utils.print2DArray

object BucketFill {

  def main(args : Array[String]): Unit = {
    println("Bucket fill algorithm...")
    var inputArray = Array.ofDim[Int](4,4)
    inputArray(0) = Array(1,1,1,2)
    inputArray(1) = Array(1,2,2,3)
    inputArray(2) = Array(1,2,2,1)
    inputArray(3) = Array(2,2,2,2)
    println("Array is ")
    print2DArray(inputArray)

    var x : Int = 0
    var y : Int = 2
    var srcColor = inputArray(x)(y)
    println(s"Input Color: $srcColor")
    var descColor = 3
    BucketFillArray(inputArray, srcColor, descColor, x,y)
    println("Result array:")
    print2DArray(inputArray)
  }

  def BucketFillArray[A](array: Array[Array[A]], srcColor: A, destColor : A, x: Int, y : Int): Unit = {
    var n = array.size
    if (n == 0) {
      println("Empty array...")
      return
    }
    var m = array(0).size
    if (x < 0 || y < 0 || x >= n || y >= m) {
      println(s"Index out of Bound:($x, $y)")
      return
    }
    else if (array(x)(y)== destColor) {
      println(s"Color matched..($x, $y) with $destColor")
      return
    }
    else if (array(x)(y)== srcColor) {
      array(x)(y) = destColor
      var neighbours = returnNeighbours(x,y)
      for (nei <- neighbours) {
        BucketFillArray(array, srcColor, destColor, nei(0), nei(1))
      }
    }
  }

  def returnNeighbours(x: Int, y: Int): Array[Array[Int]] = {
    return Array(
      Array(x, y+1),
      Array(x, y-1),
      Array(x-1, y),
      Array(x-1, y-1),
      Array(x-1, y+1),
      Array(x+1, y),
      Array(x+1, y-1),
      Array(x+1 , y+1)
    )
  }
}
