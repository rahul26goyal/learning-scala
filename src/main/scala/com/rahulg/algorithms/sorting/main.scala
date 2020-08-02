package com.rahulg.algorithms.sorting

object main {

  def main(args : Array[String]): Unit = {
    println("Running Sorting package..")
    QuickSort.test()
    HeapSort.test()
    MergeSort.test()
  }

  def show(arr : Array[Int]): Unit = {
    for(i <- arr) {
      print(s"${i} ")
    }
    println("************")
  }

}
