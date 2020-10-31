package com.rahulg.algorithms.dp

import scala.collection.mutable

/**
 * Problem: https://www.geeksforgeeks.org/min-cost-path-dp-6/?ref=lbp
 * Really helpful to Understand Dynamic Programming.
 */
object MinCostPath {

  def main(args: Array[String]): Unit ={

    val cost = getCostArray()
    val res = minCostPathDpBottomUp(cost)
    println(s"Minimum Cost to reach from (0,0) to end: ${res}")

  }

  def minCostPathDpBottomUp(cost: Array[Array[Int]]): Int = {
    val n = cost.length -1
    val m  = cost(0).length -1

    val dpCache = Array.ofDim[Int](n+1, m+1)

    for(i<- 0 to n) {
      for(j <- 0 to m ) {
        if(i ==0 && j == 0) {
          dpCache(i)(j) = cost(i)(j)
        }
        else {
          dpCache(i)(j) = cost(i)(j) + getMin(getOrMax(dpCache, i-1, j-1),
            getOrMax(dpCache, i, j-1), getOrMax(dpCache, i-1, j))
        }
      }
    }
    val returnVal = dpCache(n)(m)
    val path = new mutable.ArrayStack[(Int, Int)]()
    var i = n
    var j = m
    var nextVal = returnVal
    while(i >= 0 && j >= 0) {
      path.push((i, j))
      nextVal = nextVal - cost(i)(j) // subtract the current cost from total.
      // look for the neighbour having the remaining code.
      val (a,b) = getNeighbour(dpCache, nextVal, i, j)
      i = a
      j = b
    }
    //path.push((0,0))
    println(s"Path: ${path.toList.reverse}")
    returnVal
  }

  def getNeighbour(dpCache: Array[Array[Int]], cost: Int, i: Int, j: Int): (Int, Int) = {
    if(getOrMax(dpCache, i-1, j-1) == cost) {
      return (i-1, j-1)
    }
    if(getOrMax(dpCache, i, j-1) == cost) {
      return (i, j-1)
    }
    if(getOrMax(dpCache, i-1, j) == cost) {
      return (i-1, j)
    }
    (-1, -1)
  }
  def getOrMax(array: Array[Array[Int]], i: Int, j: Int): Int ={
    if(i >= 0 && j >= 0) {
      return array(i)(j)
    }
    Integer.MAX_VALUE
  }
  def getMin(value: Int, value1: Int, value2: Int): Int = {
    if(value < value1) {
      scala.math.min(value, value2)
    } else {
      scala.math.min(value1, value2)
    }
  }

  def getCostArray(): Array[Array[Int]] = {
    Array(
      Array(1,2,3),
      Array(4,8,2),
      Array(1,5,3)
    )
  }

}
