package com.rahulg.basics

object MatchExpression {

  def run(): Unit = {
    var input = 123
    println(s"Printing the $input in words: ")
    while(input != 0) {
      var digit = input % 10
      input = input / 10
      digit match  {
        case 0 => println("Zero ")
        case 1 => println("One ")
        case 2 => println("Two ")
        case 3=> println("Three ")
        case 4=> println("Four ")
        case 5 => println("Five ")
        case 6 => println("Six ")
        case 7 => println("Seven ")
        case 8 => println("Eight ")
        case 9 => println("Nine ")
        case _ => println("Invalid ")
      }
    }

    //Extract Even Digits from the input
    input = 123456
    var evenDigits = List[Int]()
    while(input != 0) {
      var digit = input % 10
      input = input / 10

      digit match {
        case x if (x %2 == 0) =>
        {
          evenDigits = evenDigits :+ x
        }
        case _ => {
          //skip odd
        }
      }
    }

    println(s"The even digits of 123456 are : $evenDigits")

  }
/*
  //some more examples s
  def echoWhatYouGaveMe(x: Any): String = x match {

    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty List"

    // sequence patterns
    case List(0, _, _) => "a three-element list with 0 as the first element"
    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector starting with 1, having any number of elements"

    // tuples
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b, and $c"

    // constructor patterns
    case Person(first, "Alexander") => s"found an Alexander, first name = $first"
    case Dog("Suka") => "found a dog named Suka"

    // typed patterns
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case d: Dog => s"dog: ${d.name}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => m.toString

    // the default wildcard pattern
    case _ => "Unknown"
  }

 */
}
