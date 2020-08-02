package com.rahulg.classes

import javax.jws.soap.SOAPBinding.Use

object AuxilaryClasses {

  class AuxiliaryConsUser( private var name: String, val age : Int) {
    println(" Always execute the class body..")
    def this() {
      this("DefaultName", 50);
      println("Calling Auxiliary Cont with no args..")
    }

    def this(name: String) {
      this(name, 50)
      println("Calling Auxiliary Cont with one are name: " + name)
    }

    /*
    //the below cons is not valid as we already have a primary const with 2 argss.
    def this(name : String, age : Int) {
      this(name, age)
      println("Calling Auxiliary Cont with both args: " + name + ":" + age)
    }
     */

    def this(name : String, age : Int, other : String) {
      this(name, age)
      println("Calling Auxiliary Cont with 3 args: " + name + ":" + age + ":" + other)
    }


    def display(userType : String): Unit = {
      println(s"$userType : $name  => $age")
    }

  }

  class EmptyPrimaryConstructor {
     println("Creating new EmptyPrimaryConstructor User.")
    var name : String = "";
    var age: Int = 20;

    def this(name: String) {
      this()
      this.name = name;
      println("Name Initialized..")
    }

    def this(name : String, age: Int) {
      this(name)
      this.age = age;
      println("Age Initialized..")
    }

    def display(): Unit = {
      println(s"User: ${this.name} : ${this.age}")
    }

  }

  def run(): Unit = {
    println("Examples of using Auxilary Constructors with primary constructors.s")
    var primaryUser  = new AuxiliaryConsUser("Ram", 35)
    primaryUser.display("primaryUser")

    var defaultUser = new AuxiliaryConsUser();
    defaultUser.display("defaultUser")

    var argUser1 = new AuxiliaryConsUser("Ramesh")
    argUser1.display("argUser1")

    var argUser3 = new AuxiliaryConsUser("Ramesh" , 30, "Extra args")
    argUser1.display("argUser3")

    // Empty Primary Constructor Examples...
    var u4 = new EmptyPrimaryConstructor("Rahul");
    u4.display()

    var u5 = new EmptyPrimaryConstructor("Rahul", 30);
    u4.display()

  }

}
