package com.rahulg.concurrency.basics

/**
 * This code demos how 2 threads can be used to concurrently process a given task.
 *
 */
object SumUsingTwoThread {

  def main(args: Array[String]): Unit = {
    var arr = Array(1,2,3,4,5,6,7,8,9, 10)
    val half = arr.length/2
    val obj1 = new CalculateSum(arr, 0, half)
    val obj2 = new CalculateSum(arr, half+1, arr.length -1)

    val thread1 = new Thread(new WorkerThread(obj1))
    val thread2 = new Thread(new WorkerThread(obj2))
    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    val result = obj1.getSum + obj2.getSum
    println(s"Sum: ${result}")
  }

}


class CalculateSum(arr: Array[Int], start: Int, end: Int) {
  var sum : Int = 0
  //override def run(): Unit = {
  def process(): Unit = {
    println(s"Calculating SUm in ${Thread.currentThread().getName} for ${start}, ${`end`}")
    var i = start
    while(i <= end) {
      sum += arr(i)
      i += 1
    }
  }

  def getSum: Int = this.sum
}

class WorkerThread(obj: CalculateSum) extends Runnable {
  override def run(): Unit = {
    obj.process()
  }
}