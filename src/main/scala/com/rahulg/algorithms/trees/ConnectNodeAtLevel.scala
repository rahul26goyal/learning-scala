package com.rahulg.algorithms.trees

class TreeNodeWithParent(init: Int) {
  val data: Int = init
  var left, right, nextRight : TreeNodeWithParent = null

}

object ConnectNodeAtLevel {
  /**
                          10
                  5                  20
              1      8          15           25
           0                                         50
   **/

  def main(args: Array[String]): Unit = {
    val tree = new TreeNodeWithParent(10);
    tree.left = new TreeNodeWithParent(5);
    tree.right = new TreeNodeWithParent(20);

    tree.left.left = new TreeNodeWithParent(1);
    tree.left.right = new TreeNodeWithParent(8);

    tree.left.left.left = new TreeNodeWithParent(0);

    tree.right.left = new TreeNodeWithParent(15);
    tree.right.right = new TreeNodeWithParent(25);
    tree.right.right.right = new TreeNodeWithParent(50);
    connectNodeAtLevel(tree)
    printLevel(tree.left.left)
    printLevel(tree.left.left.left)
  }

  def printLevel(parent: TreeNodeWithParent): Unit = {
    println(s"Printingg Level's right Childern's start at: ${parent.data}")
    var start = parent
    while(start != null) {
      println(s"Val: ${start.data}")
      start = start.nextRight
    }
  }

  def connectNodeAtLevel(root: TreeNodeWithParent): Unit = {
    if(root == null) {
      return
    }

    // fill from right to left in the same level..
    if(root.nextRight != null) {
      connectNodeAtLevel(root.nextRight)
    }
    // continue below..
    if(root.left != null) { //if left
      if(root.right != null) { // if right, set both left and right and iterate on left.
        root.left.nextRight = root.right
        root.right.nextRight = getNextRight(root)
      }
      else { // if no right, set only left as nextRight.
        root.left.nextRight = getNextRight(root)
      }
      connectNodeAtLevel(root.left)
    }
    else if(root.right != null) { // if no left, but right exist, set right and move
      root.right.nextRight = getNextRight(root)
      connectNodeAtLevel(root.right)
    }
    else { // leaf node, move to nextRight.
      connectNodeAtLevel(getNextRight(root))
    }
  }

  def getNextRight(node: TreeNodeWithParent): TreeNodeWithParent = {
    var start = node.nextRight
    while(start != null) {
      if(start.left != null) {
        return start.left
      }
      if(start.right != null) {
        return start.right
      }
      start = start.nextRight
    }
    return start
  }


}
