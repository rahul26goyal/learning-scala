package com.rahulg.algorithms

import com.rahulg.algorithms.MinCountSketch.{hashFunctionCount, hashPrimePairs}
import com.rahulg.collections.Utils
/**
 * A Data Structure for Min Count Sketch Implementtion.
 * One can also refer: https://gist.github.com/VarunVats9/7f379199d7658b96d479ee3c945f1b4a
 * @param maxSize
 */
class MinCountSketch[A](val maxSize: Int) {

  // by default initialized to 0
  private val sketch = Array.ofDim[Int](hashFunctionCount, maxSize)

  def printSketch(): Unit = {
    println("Printing the Sketch table.....")
    Utils.print2DArray(sketch)
  }

  def process(input: A): Unit = {
    /*val hash = input.hashCode()
    val h1 = hashFunction(hash, 0)
    val h2 = hashFunction(hash, 1)
    val h3 = hashFunction(hash, 2)
    val h4 = hashFunction(hash, 3)
    updateSketch(0, h1)
    updateSketch(1, h2)
    updateSketch(2, h3)
    updateSketch(3, h4)
     */

    val hashes = getHashValues(input)
    println(s"hashes for ${input} is ${hashes.toList}")
    for (i <- 0 until hashFunctionCount) {
      updateSketch(i, hashes(i))
    }

  }

  def getHashValues(input: A): Array[Int] = {
    val result = new Array[Int](hashFunctionCount)
    val hash = input.hashCode()
    //println(s"hash: ${hash}")
    for(i <- 0 until hashFunctionCount) {
      result(i) = hashFunction(hash, i)
      //println(s"res: ${result(i)}")
    }
    result
  }

  def updateSketch(i: Int, j : Int): Unit = {
    sketch(i)(j) = sketch(i)(j) + 1
  }

  def hashFunction(hash: Int, hashFuncNumber: Int): Int = {
    val (a, b) = hashPrimePairs(hashFuncNumber)
    (((((hash % maxSize) * a) % maxSize) * b) % maxSize)
  }

  def getFrequency(input: A): Int = {
    val hashes = getHashValues(input)
    //println(s"hashes for ${input} is ${hashes.toList}")
    var min = Int.MaxValue
    for (i <- 0 until hashFunctionCount) {
      val value = sketch(i)(hashes(i))
      if(value < min) {
        min = value
      }
    }
    return min

  }


}

object MinCountSketch {

  private val hashFunctionCount = 4
  private val hashPrimePairs:  Array[(Int, Int)] = Array((11, 9), (17, 15), (31, 29), (47, 61))

}

object Test {

  def main(args: Array[String]): Unit = {

    val obj = new MinCountSketch[Char](29)
    val input = "ABAACBDEFBGYJUJ"
    for(i <- 0 until input.length) {
      obj.process(input(i))
    }
    obj.printSketch()
    for(i <- 0 until input.length) {
      println(s"Frequency of ${input(i)} is: ${obj.getFrequency(input(i))}")
    }
  }
}
