package com.rahulg.algorithms.trees

import scala.collection.mutable

object BinaryTree {

  def main(args: Array[String]): Unit = {
    val inputs = Array(2,3,4,5,6,7)
    //val tree = new BinaryTree(1)
    val tree = new BTreeNode[Int](1)
    //tree.printPreOrder()
    BTree.printInOrder(tree)
    for (ele <- inputs) {
      InsertIntoBinaryTree(tree, ele)
    }
    println("Printing tree printPreOrder...")
    BTree.printInOrder(tree)
  }

  def InsertIntoBinaryTree[A](root : BTreeNode[A], data : A): Unit = {
    var queue : mutable.Queue[BTreeNode[A]] = new mutable.Queue[BTreeNode[A]]()
    queue.enqueue(root)
    while(!queue.isEmpty) {
      var tree : BTreeNode[A] = queue.dequeue()
      if (tree.leftChild == null) {
        tree.leftChild = new BTreeNode[A](data)
        return
      }
      else if (tree.rightChild == null) {
        tree.rightChild = new BTreeNode[A](data)
        return
      }
      else {
        queue.enqueue(tree.leftChild)
        queue.enqueue(tree.rightChild)

      }
    }
  }
}
