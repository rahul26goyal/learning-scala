package com.rahulg.basics

object CalculatorFunction {

  def run() : Unit = {

    var op = 7;

    val squareFunc = (a: Int) => {
      println("Using anonymous function square..")
      a * a
    }
    //define another anonymois function to demo higher order function.
    var reminder = (a: Int, b: Int ) => {
      a%b;
    }

    var result = op match  {
      case 1 => add(1,2);
      case 2 => subtract(5, 2);
      case 3 => multiply(2,3);
      case 5 => squareFunc(10) //using anolymous function
      case 6 => calculate_someop(10, 4, reminder) // higher order function.
      //case 7 =>
      case _ => {
        println("Invali op.: $op")
        -1
      }
    }
    println(s"Result of op: $op is : $result")
  }

  def add(x: Int, y : Int) : Int = {
    return x + y;
  }

  def subtract(x: Int, y : Int) : Int = {
    x - y; //return is optional.
  }

  def multiply(x: Int, y : Int) : Int = x * y;  //single expression function.

  //defining the hight order function which takes a function as argument,

  def calculate_someop(i: Int, j: Int, function: (Int, Int) => Int): Int = {
    println(s"Calculating reminder usign a higher order function ...") //
    function(i, j)
  }

}
