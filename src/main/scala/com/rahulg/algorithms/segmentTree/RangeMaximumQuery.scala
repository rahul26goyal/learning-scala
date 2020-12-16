package com.rahulg.algorithms.segmentTree

/**
 * https://www.geeksforgeeks.org/segment-tree-set-2-range-maximum-query-node-update/?ref=rp
 */
object RangeMaximumQuery {
  def main(args: Array[String]): Unit = {
    val input = Array(1,2,3,4,5,6,7)
    usingTreeBasedSegmentTree(input)
  }
  def usingTreeBasedSegmentTree(input: Array[Int]): Unit = {
    val approach1 = new MaxSegmentTree(input)
    approach1.queryMaximum(0, input.length -1)
    approach1.queryMaximum(1, input.length -1)
    approach1.queryMaximum(2,5)
    approach1.queryMaximum(0, 2)

    approach1.update(3, 13)
    approach1.queryMaximum(0, input.length -1)
    approach1.queryMaximum(0, 3)
    approach1.queryMaximum(4, input.length -1)

    approach1.update(0, 23)
    approach1.queryMaximum(0, 3)

    approach1.update(input.length-1, 33)
    approach1.queryMaximum(0, input.length -1)

  }

}

class MaxSegmentNode {
  // Boundary [low, high]
  var segmentRange: (Int, Int) = null
  var maxValue : Int = 0
  var left: MaxSegmentNode = null
  var right: MaxSegmentNode = null

  def getMaxChildValue: Int = {
    if(left == null) {
      return right.maxValue
    }
    if(right == null) {
      return left.maxValue
    }
    return math.max(left.maxValue, right.maxValue)
  }
}

class MaxSegmentTree(in: Array[Int]) {

  var maxSegmentRoot : MaxSegmentNode = null
  var input: Array[Int] = in
  var inputSize = input.length

  initialize()

  def initialize(): Unit = {
    for(i<- 0 until inputSize) {
      maxSegmentRoot = insert(maxSegmentRoot, i, input(i), (0, inputSize -1))
    }
    println(s"Input List: ${input.toList}")
    println("Max Seg Tree Inorder:")
    printTreeInOrder(maxSegmentRoot)
    println()
  }

  def printTreeInOrder(node: MaxSegmentNode): Unit = {
    if(node == null) {return}
    printTreeInOrder(node.left)
    print(s"${node.maxValue}, ")
    printTreeInOrder(node.right)
  }

  def getMid(curSegRange: (Int, Int)): Int = {
    curSegRange._1 + (curSegRange._2 - curSegRange._1)/2
  }

  def insert(root: MaxSegmentNode, inputIndex: Int, value: Int, curSegRange: (Int, Int)): MaxSegmentNode = {
    // in scala arguments are immutable, so need another place holder.
    var node: MaxSegmentNode = root
    if(node == null) {
      node = new MaxSegmentNode()
      node.segmentRange = (curSegRange._1, curSegRange._2)
    }
    // leaf node.
    if(curSegRange._1 == curSegRange._2) {
      node.maxValue = value
      return node
    }

    val mid = getMid(curSegRange)
    if(inputIndex <= mid) {
      node.left = insert(node.left, inputIndex, value, (curSegRange._1, mid))
    }
    else {
      node.right = insert(node.right, inputIndex, value, (mid+1, curSegRange._2))
    }
    node.maxValue = node.getMaxChildValue
    return node
  }

  def update(index: Int, newValue: Int): Unit = {
    if(index < 0 || index >= inputSize) {
      throw new Exception(s"Invalid index: ${index}")
    }
    updateMaxTree(maxSegmentRoot, index, newValue)
    println(s"Index: ${index} updated with value: ${newValue}")
  }

  def updateMaxTree(root: MaxSegmentNode, index: Int, newValue: Int): Unit = {
    //  we should not reach null root any any time.
    if(root == null) {
      throw new Exception("Invali Tree Construction")
    }
    // leaf node to be updated.
    if(root.segmentRange._1 == root.segmentRange._2) {
      input(index) = newValue
      root.maxValue = newValue
      return
    }
    val mid = getMid(root.segmentRange)
    if(index <= mid) {
      updateMaxTree(root.left, index, newValue)
    }
    else {
      updateMaxTree(root.right, index, newValue)
    }
    root.maxValue = root.getMaxChildValue
  }

  def queryMaximum(start: Int, end: Int): Int ={
    if(start < 0 || end >= inputSize) {
      throw new Exception(s"Invalid Query range ${(start, end)}")
    }

    val res = querySegTree(maxSegmentRoot, (start, end))
    println(s"Maximum for given range: ${(start, end)} is: ${res}")
    res
  }

  /**
   *
   * @param curNode : Node of a seg tree.
   * @param queryRange
   */
  def querySegTree(curNode: MaxSegmentNode, queryRange: (Int, Int)): Int = {
    if(curNode == null) {
      return Int.MinValue
    }

    val qStart = queryRange._1
    val qEnd = queryRange._2
    // check if within range or leaf
    if(qStart <= curNode.segmentRange._1 && qEnd >= curNode.segmentRange._2) {
      return curNode.maxValue
    }
    // check for out of range in lower bound
    // queryRange(2,4) - curSegRange(1,1)
    if(curNode.segmentRange._2 < qStart) {
      return Int.MinValue
    }
    // check for out of range in lower bound
    // queryRange(2,4) - curSegRange(5,5)
    if(curNode.segmentRange._1 > qEnd) {
      return Int.MinValue
    }
    val leftMax :Int = querySegTree(curNode.left, queryRange)
    val rightMax : Int = querySegTree(curNode.right, queryRange)
    return math.max(leftMax, rightMax)
  }
}
