package com.rahulg.collections

import collection.mutable

object HashMapExample {

  def main(args: Array[String]): Unit = {

    var hashMap = new mutable.HashMap[Int, String]()

    addEntries(hashMap)

    printMap(hashMap)
  }

  def addEntries(hashMap: mutable.HashMap[Int, String]): Unit = {
    hashMap.put(1, "One")
    hashMap.update(2, "Two")
    hashMap.+=((3, "Three"))
    hashMap.put(4, "Four")
  }

  def printMap(hashMap: mutable.HashMap[Int, String]): Unit = {
    println("Printing using ******foreach***********")
    hashMap.foreach( elem => {
      println(s"Elem: key:${elem._1} => ${elem._2}")
    })

    println("Print using custom func: *****printFunc()****")

    def printFunc(elem: (Int, String)): Unit = {
      println(s"Elem: key:${elem._1} => ${elem._2}")
    }

    hashMap.foreach(printFunc)

  }


}
