package com.rahulg.algorithms.heaps

object main {

  def main(array: Array[String]): Unit = {
    println("Running heaps package..")
    HeapUtils.test()
  }

  def show(arr : Array[Int]): Unit = {
    for(i <- arr) {
      print(s"${i} ")
    }
    println("************")
  }

}
