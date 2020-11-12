package com.rahulg.algorithms.trees

class TreeNode[T](init: T) {
  val data : T = init
  var left : TreeNode[T] = null
  var right : TreeNode[T] = null
}

object LowestCommonAncestor {

  def main(args: Array[String]): Unit = {
    val tree = new TreeNode[Int](10);
    tree.left = new TreeNode[Int](5);
    tree.right = new TreeNode[Int](20);

    tree.left.left = new TreeNode[Int](1);
    tree.left.right = new TreeNode[Int](8);

    tree.right.left = new TreeNode[Int](15);
    tree.right.right = new TreeNode[Int](25);
    tree.right.right.right = new TreeNode[Int](50);

    println(s"LCA of 10, 5 is ${getLCA(tree, tree, tree.left).data}")
    println(s"LCA of 25, 20 is ${getLCA(tree, tree.left, tree.right).data}")
    println(s"LCA of 1, 8 is ${getLCA(tree, tree.left.left, tree.left.right).data}")
  }

  def getLCA[T](root: TreeNode[T], node1: TreeNode[T], node2: TreeNode[T]): TreeNode[T] = {
    if(root == null) {
      return null
    }

    if(root == node1 || root == node2) {
      return root
    }

    val left_side = getLCA(root.left, node1, node2)
    val right_side = getLCA(root.right, node1, node2)
    if(left_side != null && right_side != null) {
      return root
    }
    if(left_side != null) {
      return left_side
    }
    if(right_side != null) {
      return right_side
    }
    return null
  }

}
