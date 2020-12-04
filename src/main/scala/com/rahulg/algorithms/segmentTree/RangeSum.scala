package com.rahulg.algorithms.segmentTree

/**
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 *
 * Let us consider the following problem to understand Segment Trees.
 *
 * We have an array arr[0 . . . n-1]. We should be able to
 * 1 Find the sum of elements from index l to r where 0 <= l <= r <= n-1
 *
 * 2 Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1.
 */
object RangeSum {

  def main(args: Array[String]): Unit = {
    val input = Array(1,3,5,7,9)
    //usingPrefixSum(input)
    usingArrayBasedSegmentTree(input)


  }
  def usingArrayBasedSegmentTree(input: Array[Int]): Unit = {
    val approach1 = new ArrayBasedSegmentTree()
    approach1.constructSumTreeRecursive(input)
    println("Using ArrayBasedSegmentTree to query:::")
    println(s"Sum 0 to 4: ${approach1.query(0, 4)}")
    println(s"Sum 1 to 3: ${approach1.query(1, 3)}")
    println(s"Sum 2 to 4: ${approach1.query(2, 4)}")
    //println(s"Sum 2 to 5: ${approach1.query(2, 5)}")
    println("Update  value for index 0 to 2")
    approach1.updateValue(2, 0)

    println(s"Sum 0 to 4: ${approach1.query(0, 4)}")
    println(s"Sum 1 to 3: ${approach1.query(1, 3)}")
    println(s"Sum 2 to 4: ${approach1.query(2, 4)}")

  }
  def usingPrefixSum(input: Array[Int]): Unit = {
    val approach1 = new PrefixSumApproach(input)
    println(s"Input: ${input.toList}")
    println("Using PrefixSumApproach to query:::")
    println(s"Sum 0 to 4: ${approach1.query(0, 4)}")
    println(s"Sum 1 to 3: ${approach1.query(1, 3)}")
    println(s"Sum 2 to 4: ${approach1.query(2, 4)}")
    println(s"Sum 2 to 5: ${approach1.query(2, 5)}")

    println("Adding 5 to index 2. update: (2,5)")
    approach1.update(2, 5)
    println(s"Sum 2 to 4: ${approach1.query(2, 4)}")
  }
}


class ArrayBasedSegmentTree {

  var segmentTree : Array[Int] = null
  var size: Int = 0

  var inputArray : Array[Int] = null
  var inputSize : Int = 0

  def initialize(inputSize: Int): Unit = {
    // No of leaf Nodes = inputSize
    // No of internal Nodex= inputSize - 1
    // total: 2 * InputSize -1
    size = inputSize * 2 - 1
    this.inputSize = inputSize
    segmentTree = new Array[Int](size)
  }

  /**
   *
   * @param input: Input Values.
   */
  def constructSumTreeRecursive(input: Array[Int]): Unit = {
    this.inputArray = input
    initialize(input.length)
    constructSumTreeRecursiveUtil(input, (0, inputSize -1), 0)
    println(s"Input List: ${input.toList}")
    println(s"Sum Segment Tree: ${segmentTree.toList}")
  }

  /**
   *
   * @param input : Input Array
   * @param curSegRange : (startIndex, endIndex)
   * @param curSegIndex : Current Index of Segment Tree Array to be populated.
   */
  def constructSumTreeRecursiveUtil(input: Array[Int], curSegRange: (Int, Int), curSegIndex: Int): Int = {
    val si = curSegRange._1  // start index range
    val ei = curSegRange._2  // end index of the range.
    // when size becomes 1, insert into segment tree.
    if(si == ei) {
      segmentTree(curSegIndex)= input(si)
      return segmentTree(curSegIndex)
    }
    // left child index wrt curSegIndex
    val left = curSegIndex * 2 +1
    // right child index wrt curSegIndex
    val right = curSegIndex * 2 + 2
    val mid = si + (ei-si)/2

    // construct from si..mid into left Index of Segment tree
    val leftSum =  constructSumTreeRecursiveUtil(input, (si, mid), left)
    // construct from (mid +1 ..se) into right Index of Segment tree
    val rightSum =  constructSumTreeRecursiveUtil(input, (mid+1, ei), right)
    // currNode is sum of leftNode + rightNode
    segmentTree(curSegIndex) = leftSum + rightSum
    segmentTree(curSegIndex)
  }

  // (start, end)
  def query(range: (Int, Int)): Int = {
    if(range._1 < 0 || range._2 >= inputSize || range._2 < range._1) {
      throw new Exception(s"Invalid range: ${range.toString()}")
    }

    return getSumInRange(0, (0, inputSize -1), range)
  }

  def getSumInRange(curSegIndex: Int, curSegRange: (Int, Int), queryRange: (Int, Int)): Int = {
    // if queryRange in curSegRange, return  curSegIndex
    if(queryRange._1 <= curSegRange._1 && queryRange._2 >= curSegRange._2) {
      return segmentTree(curSegIndex)
    }
    // out of range query => return 0
    // endSegmentIndex is lesser than startQueryIndex or   strartSegIndex is greater than endQueryRange
    if(curSegRange._2 < queryRange._1 || curSegRange._1 > queryRange._2) {
      return 0
    }
    val mid = curSegRange._1 + (curSegRange._2 - curSegRange._1) / 2
    // left child index wrt curSegIndex
    val left = curSegIndex * 2 +1
    // right child index wrt curSegIndex
    val right = curSegIndex * 2 + 2
    return getSumInRange(left, (curSegRange._1, mid),queryRange) +
      getSumInRange(right, (mid +1, curSegRange._2),queryRange)
  }

  def updateValue(newValue: Int, index: Int): Unit = {
    if(index < 0 || index >= inputSize) {
      return
    }
    val diff = newValue - inputArray(index)
    inputArray(index) = newValue

    updateValueInSegmentTree((0, inputSize -1), index, diff, 0)
    println(s"Updated Input: ${inputArray.toList}")
    println(s"Updated Segment Tree: ${segmentTree.toList}")
  }

  /**
   *
   * @param curSegRange
   * @param updateIndex
   * @param updateDiff
   * @param curSegIndex
   */
  def updateValueInSegmentTree(curSegRange: (Int, Int), updateIndex: Int, updateDiff: Int, curSegIndex: Int): Unit = {
    // if updateIndex is not in the curSegRange, than we return.
    if(updateIndex < curSegRange._1 || updateIndex > curSegRange._2) {
      return
    }
    // else update the currSegIndex's value.
    segmentTree(curSegIndex) =  segmentTree(curSegIndex) + updateDiff
    // if reached leaf node, return.
    if(curSegRange._1 == curSegRange._2) {
      return
    }
    // get the mid for traversal.
    val mid = curSegRange._1 + (curSegRange._2 - curSegRange._1) / 2
    // left child index wrt curSegIndex
    val left = curSegIndex * 2 +1
    // right child index wrt curSegIndex
    val right = curSegIndex * 2 + 2

    // see if left needs to be updated
    updateValueInSegmentTree((curSegRange._1, mid), updateIndex, updateDiff, left)
    // see if right needs to be updated
    updateValueInSegmentTree((mid + 1, curSegRange._2), updateIndex, updateDiff, right)
  }
}


class PrefixSumApproach(input: Array[Int]) {
  private  val preFixSum = new Array[Int](input.length)

  initialize()

  def initialize(): Unit = {
    if(input.length == 0) {
      return
    }
    preFixSum(0) = input(0)
    for(i<- 1 until input.length) {
      preFixSum(i) = preFixSum(i-1) + input(i)
    }
    println(s"PrefixSum array: ${preFixSum.toList}")
  }

  def query(start: Int, end: Int): Int = {
    if(start < 0 || end >= input.length) {
      return -1
    }
    if(start == 0) {
      return preFixSum(end)
    }
    return preFixSum(end) - preFixSum(start -1)
  }

  def update(index: Int, value: Int): Unit = {
    if(index < 0 || index >= input.length) {
      return
    }
    input(index) += value
    // update prefix
    for(i <- index until input.length) {
      preFixSum(i) += value
    }
  }

}


/** Effificetn SegTree Impl:
 * https://www.geeksforgeeks.org/segment-tree-efficient-implementation/?ref=lbp
def constructSumTree(input: Array[Int]): Unit = {
    initialize(input.length)
    val inputSize = input.length

    // populate the leaf nodes of the tree.
    for(i <- 0 until inputSize) {
      segmentTree(i + inputSize - 1) = input(i)
    }

    // populate internal nodes in bottom up fashion.
    var parentIndex = inputSize - 2
    var left, right : Int = 0
    while(parentIndex >= 0) {
      left = parentIndex * 2 + 1
      right = parentIndex * 2 + 2
      segmentTree(parentIndex) = segmentTree(left) + segmentTree(right)
      parentIndex -= 1
    }
    println(s"Sum Segment Tree: ${segmentTree.toList}")
  }
 */