package com.rahulg.algorithms.trees

import scala.collection.mutable
import scala.math
object BTree {
  def main(args: Array[String]): Unit = {
    val tree = createDefaultTree()
    println(s"Height of tree: ${height(tree)}")
    println(s"Height of tree: ${tree.height}")
    printLevelOrderIterative(tree)
  }

  def height[A](tree: BTreeNode[A]): Int = {
    if(tree == null) {
      return 0
    }
    1 + math.max(height(tree.leftChild), height(tree.rightChild))
  }

  def printInOrder[A](tree : BTreeNode[A]): Unit = {
    if (tree.leftChild != null) {
      printInOrder(tree.leftChild)
    }
    println(s"Value: ${tree.getData()}")
    if (tree.rightChild != null) {
      printInOrder(tree.rightChild)
    }
  }

  def printPreOrder[A](tree : BTreeNode[A]): Unit = {
    println(s"Value: ${tree.getData()}")
    if (tree.leftChild != null) {
      printInOrder(tree.leftChild)
    }
    if (tree.rightChild != null) {
      printInOrder(tree.rightChild)
    }
  }

  def printPostOrder[A](tree : BTreeNode[A]): Unit = {
    if (tree.leftChild != null) {
      printInOrder(tree.leftChild)
    }
    if (tree.rightChild != null) {
      printInOrder(tree.rightChild)
    }
    println(s"Value: ${tree.getData()}")
  }

  def printLevelOrderIterative[A](tree: BTreeNode[A]): Unit = {
    if(tree == null) {
      return
    }
    val Q = new mutable.Queue[BTreeNode[A]]()
    Q.enqueue(tree)
    println("Printing level Order Iteratively using Q---")
    while(!Q.isEmpty) {
      val node = Q.dequeue()
      print(s"${node.getData()}, ")
      if(node.isLeft) {
        Q.enqueue(node.leftChild)
      }

      if(node.isRight) {
        Q.enqueue(node.rightChild)
      }
    }
    println()
  }

  /**
   * Creates a BST with 10 at root.
   * @tparam A
   * @return
   */
  def createDefaultTree(): BTreeNode[Int] = {
    val tree = new BTreeNode[Int](10);
    tree.leftChild = new BTreeNode[Int](5);
    tree.rightChild = new BTreeNode[Int](20);

    tree.leftChild.leftChild = new BTreeNode[Int](1);
    tree.leftChild.rightChild = new BTreeNode[Int](8);

    tree.rightChild.leftChild = new BTreeNode[Int](15);
    tree.rightChild.rightChild = new BTreeNode[Int](25);
    tree.rightChild.rightChild.rightChild = new BTreeNode[Int](50);

   tree
  }
}

class BTreeNode [A] (init : A)
{
  private val data : A = init

  var leftChild : BTreeNode[A] = _
  var rightChild : BTreeNode[A] = _

  def getData(): A = {
    this.data
  }

  def isLeaf : Boolean = {
    this.leftChild == null && this.rightChild == null
  }

  def isLeft: Boolean = {
    this.leftChild != null
  }

  def isRight: Boolean = {
    this.rightChild != null
  }

  def height: Int = BTree.height(this)
}
