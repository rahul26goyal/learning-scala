package com.rahulg.classes

object CompanionClasses {

  //private member of the CompanionClasses which can only be called from object or class of this companion
  private def createPerson(): Unit = {
    var p = Person("Test", 123)
    Person.display(p);
  }

  def run(): Unit = {
    println("RUnning Example of Person which has a Companion object ..")
    createPerson()

  }


  class Person(name: String, age: Int) {
    private var _name : String = name
    private  var _age : Int = age

    private def display: Unit = {
      println(s"Name: ${_name} : Age: ${_age}")
    }
  };

  //companion Object of person.
  object Person {

    //Helper method to create Person Object without using `new` keyword.
    def apply(name: String, age : Int): Person = {
      var p = new Person(name, age)
      p
    }

    def display(person: Person): Unit = {
      //companion object has access to private members of the Companion Class Object.
      person.display;
    }
  }





}
