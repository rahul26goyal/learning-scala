package com.rahulg.algorithms.trees

import scala.collection.mutable
object PrintRootToLeafPath {

  def main(args: Array[String]): Unit = {

    val tree: BTreeNode[Int] = BTree.createDefaultTree()

    printRootToLeaf(tree)

    //printWithoutRecursive(tree) -- TODO does not work yet..needs changes.

  }

  /**
   *
   * @param tree
   * @tparam A
   */
  def printWithoutRecursive[A](tree: BTreeNode[A]): Unit = {
    if (tree == null) {
      return
    }
    val iterStack = new mutable.Stack[BTreeNode[A]]()
    val pathStack = new mutable.ArrayStack[A]()

    iterStack.push(tree)
    while(!iterStack.isEmpty) {
      val node = iterStack.pop()
      println(s"visit node: ${node.getData()}")
      if(node.isLeaf) {
        printStackFIFO(pathStack)
        println(s"${node.getData()}")
      }
      else {
        pathStack.push(node.getData())
        if (node.rightChild != null) {
          iterStack.push(node.rightChild)
        }
        if (node.leftChild != null) {
          iterStack.push(node.leftChild)
        }
      }
    }


  }

  def printRootToLeaf[A](tree: BTreeNode[A]): Unit = {
    val arrStack = new mutable.ArrayStack[A]()
    printRecursive(tree, arrStack)
  }

  def printRecursive[A](tree: BTreeNode[A], arrStack: mutable.ArrayStack[A]): Unit = {
    if(tree == null) {
      return
    }
    println(s"node: ${tree.getData()}")
    if(tree.isLeaf) {
      printStackFIFO(arrStack)
      println(s"${tree.getData()}..")
      return
    }
    arrStack.push(tree.getData())
    printRecursive(tree.leftChild, arrStack)
    printRecursive(tree.rightChild, arrStack)
    val pop = arrStack.pop()
    println(s"Poped: $pop")
  }

  def printStackFIFO[A](arrStack: mutable.ArrayStack[A]): Unit = {
    var i = arrStack.size -1
    print("Path: ")
    while(i >= 0) {
      print(s"${arrStack.apply(i)}, ")
      i -= 1
    }
  }

}
