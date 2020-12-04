package com.rahulg.problems.array
/**
There are 'n' number of trees(plants) in a row.
We need 'x' length of wood/log from the trees.
You can choose a particular height('h', a whole number) at which all the trees(taller than 'h') will get cut.
At what height you'll make the cut so that minimum amount of wood will be cut.
Given:

* A list of numbers representing the height of trees in a row.
* A number representing the total length of wood we require.
Output:
* Height at which you'll make a cut so as to minimize the wastage of wood.


e.g.

n = 5
[10 11 12 13 14]
x = 13

h = 9

**/
object CuttingTree {

  def main(args: Array[String]) = {
    println("Hello Scala!")

    //val res = minimumHeight(Array(10, 11,12, 13, 14), 13)
    val res = minimumHeightOptimized(Array(10, 11,12, 13, 14), 2)
    println(s"Result : ${res}")
  }


  def minimumHeightOptimized(arr: Array[Int], target: Int): Int = {
    if(arr.length == 0) {
      return -1
    }
    var max = -1
    arr.foreach(x => {
      if(max < x) {
        max = x
      }
    })

    if(target == 0) {
      return max
    }
    var height = max // start with max -1

    return checkIfSatisfied(arr, 0, height -1, target)

  }

  def checkIfSatisfied(arr: Array[Int], l: Int, r: Int, target: Int): Int = {
    if(l <= r) {
      val height : Int = (l + r ) / 2

      var sum = getSum(arr, height)
      println(s"Height: ${height}, sum: ${sum}")
      if(sum == target) {
        return height
      }
      else if( sum < target) {
        println(s"return: less")
        return checkIfSatisfied(arr, l, height -1, target)
      }
      else if(sum > target){
        val resp = checkIfSatisfied(arr, height +1, r, target)
        println(s"sum greater: new: ${resp}: old: ${height}")
        if(resp > height) {
          return resp
        }
        return height
      }
    }
    return -1
  }

  def getSum(arr: Array[Int], height: Int): Int = {
    var sum : Int = 0
    arr.foreach(x => {
      if(x > height){
        sum += (x - height)
      }
    })
    return sum
  }

  def minimumHeight(arr: Array[Int], target: Int): Int = {
    if(arr.length == 0) {
      return -1
    }
    var max = -1
    arr.foreach(x => {
      if(max < x) {
        max = x
      }
    })

    if(target == 0) {
      return max
    }

    var sum = 0
    var height = max // start with max -1

    while(sum  < target && height >= 0) {
      sum = 0
      height = height -1
      arr.foreach(x => {
        if(x > height){
          sum += (x - height)
        }
      })
    }
    if(height == -1) {
      return -1 //
    }
    return height
  }

}
