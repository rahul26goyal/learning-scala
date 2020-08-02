package com.rahulg.classes

object InheritanceExample {

  abstract class Polygon(private val NoSides : Int) {
  //abstract class Polygon {
    println("Initialize Polygon with Sides: "+ NoSides)


    /*def this() {
      this(0)
      //throw Exception("NUmber of Sides needs to ba passed...")
    }*/

    def area(): Double;

    def sides() : Unit = {
      println("Number of Sides :" + NoSides)
    }
  }

  class Rectangle(val length: Double, val width: Double) extends  Polygon(4) {

    def this() {
      this(1, 1);
    }

    println("Initialize Rectangle.....")

    override def area(): Double = {
      length * width
    }

    def display(): Unit = {
      this.sides();
      println(s"Length: $length : Width: $width")
      println("Area:" + area())
    }
  }

  def run(): Unit = {

    //can not instatiate a polygon class.
    //var polygon = new Polygon(3);
    var polyRect : Polygon = new Rectangle(5,2)
    polyRect.sides();
    println("Area: " + polyRect.area())
    //polyRect.display()  //will not work as the type is Polygon. So, we can access only methods defined on Polygon.

    var rect : Rectangle = new Rectangle(10, 20)
    rect.display()

    var rect2 = new Rectangle();
    rect2.display()

    show(rect)
  }

  def show(rect: Polygon): Unit = {
    //rect.disaply()  this will also now work envn thougg the

  }

}
