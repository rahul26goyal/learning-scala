package com.rahulg.algorithms.segmentTree

object RangeMinimumQuery {

  def main(args: Array[String]): Unit = {
    val input = Array(5,7,6,2,8,9,13)
    usingArrayBasedSegmentTree(input)
  }
  def usingArrayBasedSegmentTree(input: Array[Int]): Unit = {
    val approach1 = new ArrayBasedMinSegmentTree(input)
    approach1.queryMinimum(0, input.length -1)
    approach1.queryMinimum(1, input.length -1)
    approach1.queryMinimum(4,6)
    approach1.queryMinimum(0, 2)

    approach1.updateValue(2, 1)
    approach1.queryMinimum(0, input.length -1)
    approach1.queryMinimum(5, input.length -1)
    approach1.queryMinimum(4,6)
    approach1.queryMinimum(0, 2)

  }
}

class ArrayBasedMinSegmentTree(inputArray: Array[Int]) {
  private var minSegmentTree : Array[Int] = null
  private var size: Int = 0
  private val inputSize = inputArray.length

  initialize()

  def initialize(): Unit = {
    this.size = this.inputSize * 2 - 1
    minSegmentTree = new Array[Int](this.size)
    constructMinSegTree(inputArray, (0, inputSize-1), 0)
    println(s"Input: ${inputArray.toList}")
    println(s"MinSegTree: ${minSegmentTree.toList}")
  }

  def constructMinSegTree(input: Array[Int], curSegRange: (Int, Int), curSegIndex: Int): Int = {
    if(curSegRange._1 == curSegRange._2) {
      minSegmentTree(curSegIndex) = input(curSegRange._1)
      return minSegmentTree(curSegIndex)
    }

    val mid = getMid(curSegRange._1, curSegRange._2)
    val left = getLeft(curSegIndex)
    val right = getRight(curSegIndex)

    val leftMin = constructMinSegTree(input, (curSegRange._1, mid), left)
    val rightMin = constructMinSegTree(input, ( mid + 1, curSegRange._2), right)

    minSegmentTree(curSegIndex) = math.min(leftMin, rightMin)
    minSegmentTree(curSegIndex)
  }

  /**
   *
   * @param queryRange
   */
  def queryMinimum(queryRange: (Int, Int)): Int = {
    if(queryRange._1 < 0 || queryRange._2 >= inputSize || queryRange._1 > queryRange._2) {
      throw new Exception(s"Invalid range: ${queryRange.toString()}")
    }
    val res = getMinimum((0, inputSize -1), queryRange, 0)
    println(s"Minimum for given range: ${queryRange.toString()} is: ${res}")
    return res
  }

  def getMinimum(curSegRange: (Int, Int), queryRange: (Int, Int), curSegIndex: Int): Int = {
    // check if with in range.
    if(queryRange._1 <= curSegRange._1 && queryRange._2 >= curSegRange._2) {
      return minSegmentTree(curSegIndex)
    }
    // check out of range
    if(curSegRange._1 > queryRange._2 || curSegRange._2 < queryRange._1) {
      return Int.MaxValue
    }

    val mid = getMid(curSegRange._1, curSegRange._2)
    val left = getLeft(curSegIndex)
    val right = getRight(curSegIndex)

    val leftMin = getMinimum((curSegRange._1, mid), queryRange, left)
    val rightMin = getMinimum((mid+1, curSegRange._2), queryRange, right)
    return Math.min(leftMin, rightMin)
  }

  def updateValue(index: Int, newValue: Int): Unit ={
    if(index < 0 || index >= inputSize) {
      throw new Exception("Invalid Index")
    }
    inputArray(index) = newValue
    updateSegmentTree((0, inputSize-1), 0, index, newValue)
    println(s"Input: ${inputArray.toList}")
    println(s"minSegTree: ${minSegmentTree.toList}")
  }

  /**
   *
   * @param curSegRange
   * @param curSegIndex
   * @param updateIndex
   * @param updateValue
   */
  def updateSegmentTree(curSegRange: (Int, Int), curSegIndex: Int, updateIndex: Int, updateValue: Int): Unit = {
    // reached the leaf node.
    if(curSegRange._1 == curSegRange._2) {
      minSegmentTree(curSegIndex) = updateValue
      return
    }
    val mid = getMid(curSegRange._1, curSegRange._2)
    val left = getLeft(curSegIndex)
    val right = getRight(curSegIndex)

    if(updateIndex <= mid) {
      updateSegmentTree((curSegRange._1, mid), left, updateIndex, updateValue)
    }
    else {
      updateSegmentTree((mid +1, curSegRange._2), right, updateIndex, updateValue)
    }
    minSegmentTree(curSegIndex) = math.min(minSegmentTree(left), minSegmentTree(right))
    minSegmentTree(curSegIndex)
  }

  def getMid(low: Int , high: Int): Int = {
    low + (high-low)/2
  }

  def getLeft(index: Int): Int = {
    index * 2  + 1
  }

  def getRight(index: Int): Int = {
    index * 2  + 2
  }


}