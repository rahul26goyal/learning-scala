package com.rahulg.concurrency

import akka.actor.{Actor, ActorSystem, Props}

object SimpleActor {

  def run(): Unit = {

    var system : ActorSystem = ActorSystem("Hello_Actor")

    val actor1 = system.actorOf(Props(new HelloActor("Amitab")), name = "xxx")

    actor1.!("4")
    actor1.!("3")
    actor1.!("2")
    actor1.!("1")
    actor1.!("0")

    system.stop(actor1)
    system.terminate()

  }


  class   HelloActor(name: String) extends  Actor {
    private  val _name : String = name
    override def receive: Receive = {
      case  "1" => println("RUnnnnnnnn " + _name)
      case  "2" => println("Jumppppppp " + _name)
      case  "3" => println("Danceeee " + _name)
      case  "4" => println("Dunnoooo ")
      case _ => println("Invalid..")
    }
  }


}
