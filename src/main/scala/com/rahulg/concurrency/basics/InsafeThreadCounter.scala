package com.rahulg.concurrency.basics

import scala.util.Random

object UnsafeThreadCounter {

  def main(args: Array[String]): Unit = {

    val counter = new UnsafeCounter
    val random = new Random()
    val threadForIncrement = new Thread(new Runnable {
      override def run(): Unit = {
        for(i<- 0 until 100) {
          Thread.sleep(random.nextInt(9) * 100)
          counter.increment
        }
      }
    }
    )

    val threadForDecrement = new Thread(new Runnable {
      override def run(): Unit = {
        for(i<- 0 until 100) {
          Thread.sleep(random.nextInt(9) * 100)
          counter.decrement
        }
      }
    }
    )
    threadForDecrement.start()
    threadForIncrement.start()

    threadForIncrement.join()
    threadForDecrement.join()

    counter.printCounter
  }

}


class UnsafeCounter {
  var count = 0

  def increment : Unit = {
    count += 1
  }
  def decrement : Unit = count -= 1

  def printCounter: Unit = {
    println(s"Counter value is: ${count}")
  }
}