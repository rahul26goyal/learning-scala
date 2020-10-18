package com.rahulg.algorithms.linklist

object LinkListUtil {

  def main(args: Array[String]): Unit = {
   val head : LNode[Int] = null
    //createDefaultList(head)
  }

}


class LNode[A](val data : A) {
  var next: LNode[A] = null

  def isEnd(): Boolean = {
    next == null
  }
}
