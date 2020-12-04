package com.rahulg.algorithms.trees

object RootToLeafSum {

  def main(args: Array[String]): Unit = {
    val tree: BTreeNode[Int] = BTree.createDefaultTree()

    printAllRootToLeafSum(tree, 0)

    println(s"Check if Sum 105 exist: ${checkIfSumExist(tree, 105)}")
    println(s"Check if Sum 16 exist: ${checkIfSumExist(tree, 16)}")
    println(s"Check if Sum 166 exist: ${checkIfSumExist(tree, 166)}")

  }

  def printAllRootToLeafSum(root: BTreeNode[Int], curSum: Int): Unit = {
    if(root == null) {
      return
    }
    var sum = curSum + root.getData()
    if(root.isLeaf) {
      println(s"Sum ending at leaf: ${root.getData()} is ${sum}")
    }
    printAllRootToLeafSum(root.leftChild, sum)
    printAllRootToLeafSum(root.rightChild, sum)
  }

  def checkIfSumExist(root: BTreeNode[Int], curSum: Int): Boolean = {
    if(root == null) {
      return curSum == 0
    }
    val leftSum = curSum - root.getData()
    if(root.isLeaf) {
      return leftSum == 0
    }
    return checkIfSumExist(root.leftChild, leftSum) ||
      checkIfSumExist(root.rightChild, leftSum)
  }

}
