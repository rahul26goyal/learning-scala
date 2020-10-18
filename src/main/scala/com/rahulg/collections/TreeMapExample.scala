package com.rahulg.collections

import scala.collection.mutable

object TreeMapExample {

  class Data (var x : Int) extends Ordered[Data]
  {
    override def compare(that: Data): Int = x - that.x
  }

  def main(args: Array[String]): Unit = {
    println("Learning Mutable Tree Map....")
    val treeMap = new mutable.TreeMap[Int, String]

    insertValues(treeMap)

    printMap(treeMap)

    checkIfKeyExist(treeMap, 10)

    multiplyKeyByValue(treeMap, 10)

    printValues(treeMap)
    printKeys(treeMap)

    getSomething(treeMap)

    println("Using TreeMap Object to Initialize ...-------------")
    val emptyTreeMap = mutable.TreeMap.empty[Int, String]
    insertValues(emptyTreeMap)
    printValues(emptyTreeMap)

    val dataTreeMap = mutable.TreeMap[Data, String]()
  }

  def insertValues(treeMap: mutable.TreeMap[Int, String]): Unit = {
    treeMap.+= (3 -> "Three")
    treeMap.+= (1 -> "One")
    treeMap.+= (2-> "Two")

  }

  def printMap(treeMap: mutable.TreeMap[Int, String]): Unit = {
    println(s"Printing the ${treeMap.stringPrefix} in the sorted Order by key: size: ${treeMap.size}, Empty?:${treeMap.isEmpty}")
    println("-----------using (k,v)----------")
   for((k, v) <- treeMap) {
     println(s"Key: $k Value: $v")
   }
    println("-------------using (_1, _2)--------")
    for (elem <- treeMap) {
      println(s"Key: ${elem._1}: Value: ${elem._2}")
    }
    println("----------Using foreach()-----------")

    treeMap.foreach(elem => {
      println(s"Key: ${elem._1}: Value: ${elem._2}")
    })

    println("----------Using iterator() with next and hasNext-----------")

    val it = treeMap.iterator
    while (it.hasNext) {
      val elem: (Int, String) = it.next()
      println(s"Key: ${elem._1}: Value: ${elem._2}")
    }

    println("----------Using iterator() with for loop-----------")
    for (elem <- it) {
      println(s"Key: ${elem._1}: Value: ${elem._2}")
    }

  }

  def checkIfKeyExist(treeMap: mutable.TreeMap[Int, String], key: Int): Unit = {
    val res = treeMap.getOrElse(key, "")
    println(s"Result for $key exists in map: $res")

    val res2 = treeMap.getOrElse(3, "") // default value is "" as value is of type String.
    // getOrElse does not return Some(Value) instead directly returns the valuse.
    if (res2 != "") {
      println(s"Value for 3 is $res2")
    }

    val res3 = treeMap.get(2)
    // get on map returns Some(Value) or None.
    if (res3 != None) {
      println(s"Value for 2 is ${res3.get}")
    }

    val res4 = treeMap.get(key) //  this will return "None"
    // if (res4 != None)
    if (res4.getOrElse("") != "") {
      println(s"Value for $key is ${res4.get}")
    }
    else {
      println(s"key $key does not exist...")
    }

    println("Check using contains method:---------")

    val res5 = treeMap.contains(key)
    println(s"Key $key Exists: $res5")
    val res6 = treeMap.contains(3)
    println(s"Key 3 Exists: $res6")

  }
  def multiplyKeyByValue(treeMap: mutable.TreeMap[Int, String], factor: Int): Unit = {
    println("Update keys------------------")
    if(treeMap != null && !treeMap.isEmpty) {
      treeMap.transform((k, v) => v + s"-Fact-$factor")
      treeMap.foreach(elem => {
        println(s"Key: ${elem._1}: Value: ${elem._2}")
      })
    }
  }

  def printValues[A, B](treeMap: mutable.TreeMap[A, B]): Unit = {
    println("Printing Only Values...--using Iterator----------------")
    for(elem <- treeMap.valuesIterator) {
      println(s"Value: $elem")
    }
  }

  def printKeys[A, B](treeMap: mutable.TreeMap[A, B]): Unit = {
    println("Printing Only keys...--using Iterator----------------")
    for(elem <- treeMap.keysIterator) {
      println(s"Key: $elem")
    }
  }

  /**
   * Demonstrates how to return Option[A] from a function.
   * @param treeMap
   * @return
   */
  def getSomething(treeMap: mutable.TreeMap[Int, String]) : Option[String] = {
    if (treeMap.isEmpty) {
      None
    }
    else {
      Some(treeMap.last._2)
    }
  }
 }
