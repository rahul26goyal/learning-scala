package com.rahulg.classes

object TraitsExample {

  trait AnimalTrait {
    var name : String  //Abstract var
    val breed : String //Abstract val
    val Country: String = "India" //concret value

    def printDetails : Unit //abstract method.

    def test(): Unit = {
      println("Testing Function with Implementation....." + name + ":" + breed)

    }
  }

  class Animal (_name : String, _breead : String) extends AnimalTrait {
    var name: String = _name
    override val breed: String = _breead  //for val variable, override is needed.

    override def printDetails: Unit = {
      this.test()  //calling the trait functions
    }
  }

  def run: Unit = {
    println("Demo the example of using traits..")

    var an = new Animal("Dog", "some breed")
    an.printDetails

  }

}
