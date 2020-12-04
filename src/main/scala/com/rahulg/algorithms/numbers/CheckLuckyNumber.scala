package com.rahulg.algorithms.numbers

/**
 * https://www.geeksforgeeks.org/lucky-numbers/?ref=lbp
 * Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,
 * Take the set of integers
 * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,……
 * First, delete every second number, we get following reduced set.
 * 1,3,5,7,9,11,13,15,17,19,…………
 * Now, delete every third number, we get
 * 1, 3, 7, 9, 13, 15, 19,….….
 * Continue this process indefinitely……
 * Any number that does NOT get deleted due to above process is called “lucky”.
 * Therefore, set of lucky numbers is 1, 3, 7, 13,
 */
object CheckLuckyNumber {

  def main(args: Array[String]): Unit = {
    val n = 4
    val res = checkIfLucky(n)
    println(s"N : ${n}: is lucky : ${res}")
  }
  // this function check if the last number n is going to be lucky.
  def checkIfLucky(n: Int): Boolean = {
    var i = 2
    var currentPos = n
    while(i <= currentPos) {
      val itemToRemove = (currentPos/i).toInt
      println(s"For iteration : ${i}, currentPos: ${currentPos}, itemToRemove: ${itemToRemove}")
      if(currentPos % i == 0) {
        println(s"Item will be removed after ${i}th iteration.")
        return false
      }
      currentPos = currentPos - itemToRemove
      i += 1
    }
    println(s"Last Iteration was at : ${i -1}")
    return true
  }
}
