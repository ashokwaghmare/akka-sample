package com.example

import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.PersistentActor

trait Event extends Serializable
trait Cmd
case class Increment(counter:Int) extends Event
case class Added(c:Int) extends Cmd

class PingActor extends Actor with ExaPersistentActor with ActorLogging {
  import PingActor._


  override def persistenceId: String = entryName+"-"+11
  var counter = 0
  val privateKey = "private"


  def receiveEvent: Receive = {
    case inc: Increment =>
      println("recovering11..."+inc)
      counter = counter + inc.counter
      println("after rec counter "+counter)
  }


  override def receiveCommand: Receive = {
    case Added(c) =>
      println("counter>>"+counter)
      val encrypt = Encryption.encrypt(privateKey, Increment(c))
      writeWithoutApply(encrypt)
      println("persist counter"+counter)
      sender() ! PingMessage("1 added ping")

  }
}

object PingActor {
  val props = Props[PingActor]
  case object Initialize
  case class PingMessage(text: String)
}