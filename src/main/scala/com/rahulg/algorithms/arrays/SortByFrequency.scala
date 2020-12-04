package com.rahulg.algorithms.arrays

import scala.collection.mutable

/**
 * Sort elements by frequency in descreasing order.
 * Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 *
 */
object SortByFrequency {

  def main(args: Array[String]): Unit = {

    val input = Array(2, 5, 2, 8, 5, 6, 8, 8, 3,3,3)

    //var output : Array[Int] = sortByFrequencyWithoutOrder(input)
    //println(s"Result of sortByFrequencyWithoutOrder: ${output.toList}")

    var output : Array[Int] = sortByFrequencyWithOrder(input)
    println(s"Result of sortByFrequencyWithOrder: ${output.toList}")
  }

  def sortByFrequencyWithoutOrder(array: Array[Int]): Array[Int] = {
    val result = new Array[Int](array.length)
    //(element, frequency)
    val freqMap = new mutable.HashMap[Int, Int]()
    for(i <- 0 until array.length) {
      freqMap.put(array(i), freqMap.getOrElse(array(i), 0) + 1)
    }
    println(s"freqMap: ${freqMap}")
    // Array[(element, frequency)]
    val sortedArray: Array[(Int, Int)] = sortHashMapByValue(freqMap)
    var i = result.length -1
    var j = 0
    while(i >= 0) {
      val ele: (Int, Int) = sortedArray(j)
      j += 1
      for(k <- 1 to ele._2) {
        result(i) = ele._1
        i -= 1
      }
    }
    // sort hash map by value
    return result
  }

  def sortHashMapByValue(hashMap: mutable.HashMap[Int, Int]): Array[(Int, Int)] = {
    val arr = new Array[(Int, Int)](hashMap.size)
    var i = 0
    hashMap.foreach( ele => {
      arr(i) = (ele._1, ele._2)
      i += 1
    })
    //println(s"HashMap to array: ${arr.toList}")
    scala.util.Sorting.quickSort(arr)(Ordering.by[(Int, Int), Int](x => {x._2}))

    println(s"Sorted array by freq / 2nd ele: ${arr.toList}")
    return arr
  }


  def sortByFrequencyWithOrder(array: Array[Int]): Array[Int] = {
    val result = new Array[Int](array.length)
    //(element, (frequency, Index))
    val freqIndexMap = new mutable.HashMap[Int, (Int, Int)]()
    for(i <- 0 until array.length) {
      val ele = array(i)
      if(freqIndexMap.contains(ele)) {
        val value: (Int, Int) = freqIndexMap.get(ele).get
        freqIndexMap.put(ele, (value._1 + 1, value._2))
      }
      else {
        freqIndexMap.put(ele, (1, i))
      }
    }
    println(s"freqMap: ${freqIndexMap}")
    // Array[(element, frequency)]
    val sortedArray: Array[(Int, Int, Int)] = sortHashMapByValueIndex(freqIndexMap)
    var i = result.length -1
    var j = 0
    while(i >= 0) {
      val ele: (Int, Int, Int) = sortedArray(j)
      j += 1
      for(k <- 1 to ele._2) {
        result(i) = ele._1
        i -= 1
      }
    }
    // sort hash map by value
    return result
  }

  def sortHashMapByValueIndex(freqIndexMap: mutable.HashMap[Int, (Int, Int)]): Array[(Int, Int, Int)] = {
    //(element, frequency, Index)
    val arr = new Array[(Int, Int, Int)](freqIndexMap.size)
    var i = 0
    freqIndexMap.foreach( ele => {
      //(element, (frequency, Index))
      arr(i) = (ele._1, ele._2._1, ele._2._2)
      i += 1
    })
    println(s"Unsorted array: ${arr.toList}")
    // -x._3 because we want reverse Indexed.
    scala.util.Sorting.quickSort(arr)(Ordering.by[(Int, Int, Int), (Int, Int)](x => {(x._2, -x._3)}))

    println(s"Sorted array by (freq, rev_index) ele: ${arr.toList}")
    return arr
  }

}
