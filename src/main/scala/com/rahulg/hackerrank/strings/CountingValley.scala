package com.rahulg.hackerrank.strings

/**
 * Problem Link: https://www.hackerrank.com/challenges/counting-valleys/problem
 */
class CountingValley {
  /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     * Sample Call: `countingValleys(6, "DDDUUU")
     */

  def countingValleys(steps: Int, path: String): Int = {
    // Write your code here

    var mountain, valley = false
    var level, countMountain, countvalley = 0
    val UP = 'U'
    val DOWN = 'D'

    for(i <- 0 until path.length) {
      val step = path(i)
      if( !mountain && !valley) {
        mountain = step == UP
        valley = step == DOWN
      }
      step match {
        case UP => level += 1
        case DOWN => level -= 1
      }
      if(level == 0) {
        (mountain, valley) match {
          case (true, false) => countMountain += 1
          case (false, true) => countvalley += 1
        }
        mountain = false
        valley = false
      }
    }

    //println(s"countMountain: ${countMountain}, countvalley:${countvalley}")
    return countvalley
  }

}
