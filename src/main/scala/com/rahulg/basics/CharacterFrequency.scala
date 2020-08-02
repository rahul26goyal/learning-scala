package com.rahulg.basics

object CharacterFrequency {

  def run(): Unit = {
    var input : String = "abababababababababasjsjsjjdfjfjfjfj";
    usingImmutableMap(input)
    usingMutableMap(input)

  }

  def usingImmutableMap(input : String): Map[String, Int] ={
    println("usingImmutableMap Input: " + input)
    //immutable map.
    var charFreqMap : Map[String, Int] = Map()

    input.foreach { char =>
      print(char)
      if(charFreqMap.contains(char.toString) ) {
        charFreqMap += (char.toString -> (charFreqMap(char.toString) + 1))
      }
      else {
        charFreqMap += (char.toString -> 1)
      }
    }
    println()

    charFreqMap.keys.foreach { k =>
      println(k + " => " + charFreqMap(k))
    }

    charFreqMap
  }

  def usingMutableMap(input : String): scala.collection.mutable.Map[String, Int] ={
    println("usingMutableMap: " + input)
    //immutable map.
    var charFreqMap = scala.collection.mutable.Map[String, Int]()

    input.foreach { char =>
      print(char)
      if(charFreqMap.contains(char.toString) ) {
        charFreqMap += (char.toString -> (charFreqMap(char.toString) + 1))
      }
      else {
        charFreqMap(char.toString) = 1
      }
    }
    println()

    charFreqMap.keys.foreach { k =>
      println(k + " => " + charFreqMap(k))
    }

    charFreqMap
  }

}
