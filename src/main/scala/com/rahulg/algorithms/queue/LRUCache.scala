package com.rahulg.algorithms.queue

import collection.mutable
class LRUCache[A, B](val capacity: Int) {

  var curSize : Int = 0
  val cache = new mutable.HashMap[A, B]()

  val queue = new mutable.Queue[A]()


}
