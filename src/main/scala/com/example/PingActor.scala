package com.example

import akka.NotUsed
import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.PersistentActor

trait Event extends Serializable
trait Cmd
case class Increment(counter:Int) extends Event
case class Added(c:Int) extends Cmd

class PingActor extends Actor {
  var counter = 0
  val privateKey = "private"

  def receive: Receive = {
    case Added(c) =>
      println("adding event .."+c)
    case Subtracted(c) =>
      println("subtracted...")
    case _ => println("other...>"+self.path.name)

  }
}

object PingActor {
  val props = Props[PingActor]
  case object Initialize
  case class PingMessage(text: String)
}