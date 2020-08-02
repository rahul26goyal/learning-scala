package com.rahulg.basics

object PatternOne {

  def run(num : Int): Unit = {

    //Demostrates use of Nested for loop without writing a nested loop!!!
    //Sala magic.
    for(i <- 1 to num; j <- 1 to i) {
      print(j + " ")
      if(i == j){
        println()
      }
    }
  }

}
