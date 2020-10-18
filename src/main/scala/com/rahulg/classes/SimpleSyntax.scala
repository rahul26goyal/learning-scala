package com.rahulg.classes

object SimpleSyntax {

  //An Empty Class
  class EmptyClass;

  //Class with 2 public members.
  class MutableUser (var name: String, var age: Int); //public members of class with editable nature.

  //Class with immuatable public members.
  class ImMutableUser (val name: String, val age: Int); //both are public but val, so can not be changed after getting initialized.

  //class with private and immutable public member.
  class SecretUser (private var name: String, val age: Int) { //name is private and age is val

    def display(): Unit = {
      println("SecretUser:" + this.name + ":" + age)
    }
  }

  //a class with only primary constructor.
  class PrimaryConsUser (private var name : String, private var age: Int) {  //primary Constructor.
  }

  //class with Default type arguments.
  class DefaultUser(name: String, age : Int) { //arguments are without var or val..
    def printerName(): Unit = {
      println("DefaultUser:" + name + ":" + age)
    }
  }

  class AuxiliaryConstructor(val a : String, val b : Int) {
    println("Primary Constructor called...")
    private var name : String = a
    private var age: Int = b
    def this(name : String){
      this(name, 20)
      println("Auxiliary Constructor called...")
    }

    def display(): Unit = {
      println("AUX USER:" + name + ":" + age)
    }
  }

  def run(): Unit ={
    println("Running Simple Class syntax...")
    var ec = new EmptyClass();
    println("Empty User" + ec)

    var u1 = new MutableUser("Raj", 23)
    println("MutableUser" + u1.name + ":" + u1.age)

    u1.name ="Rajesh"
    u1.age = 43
    println("MutableUser:"+ u1.name + ":" + u1.age)

    var u2 = new ImMutableUser("Raj", 25)
    println("ImMutableUser:"+ u2.name + ":" + u2.age)
    //Throws error
    //u2.name ="Rajesh"  can not edit these.
    //u2.age = 43

    var u3 = new SecretUser("Rahul", 27)
    println("SecretUser:" + u3.display())
    //Throws error..
    //println(u3.name + ":")

   // var u4 = new PrimaryConsUser(); //this will throw error if the arguments are not passes.
    var u5 = new PrimaryConsUser("rrr", 34); //works fine.

    //default User
    var u6 = new DefaultUser("Ram", 2);
    //println(u6.name)  //no getter or setter.
    println(u6.printerName())

    //Auxilary Constructor.
    var aux = new AuxiliaryConstructor("Rahul")
    aux.display()
    // below will not call aux constructor.
    aux = new AuxiliaryConstructor("Rahul", 22)
    aux.display()
  }
}
