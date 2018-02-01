package com.example

import akka.NotUsed
import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.PersistentActor

trait Event extends Serializable
trait Cmd
case class Increment(counter:Int) extends Event
case class Added(c:Int) extends Cmd

class PingActor extends Actor with ExaPersistentActor with ActorLogging {
  import PingActor._


  override def persistenceId: String = entryName+"-"+24
  var counter = 0
  val privateKey = "private"


  def receiveEvent: Receive = {
    case inc: Increment =>
      counter = counter + inc.counter
  }


  override def receiveCommand: Receive = {
    case Added(c) =>
      val encrypt = Encryption.encrypt(privateKey, Increment(c))
      writeWithoutApply(encrypt)
    case _ => println("other...>"+self.path.name)

  }
}

object PingActor {
  val props = Props[PingActor]
  case object Initialize
  case class PingMessage(text: String)
}