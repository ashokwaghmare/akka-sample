package com.example

import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.PersistentActor

case class Decrement(counter:Int) extends Event
case class Subtracted(c:Int) extends Cmd

class PongActor extends Actor with ExaPersistentActor with ActorLogging {
  import PingActor._

  override def persistenceId: String = entryName+"-"+12
  var counter = 0
  val privateKey = "privateOfPong"


  def receiveEvent: Receive = {
    case dec: Decrement =>
      println("recovering11..."+dec)
      counter = counter - dec.counter
      println("after rec counter "+counter)
  }


  override def receiveCommand: Receive = {
    case Subtracted(c) =>
      println("counter>>"+counter)
      val encrypt = Encryption.encrypt(privateKey, Decrement(c))
      writeWithoutApply(encrypt)
      println("persist counter"+counter)
      sender() ! PingMessage("1 added ping")

  }
}

object PongActor {
  val props = Props[PongActor]
}
