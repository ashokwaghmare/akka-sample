package com.example

import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.PersistentActor

trait Event extends Serializable
trait Cmd
case class Increment(countet:Int) extends Event
case class Added(c:Int) extends Cmd
class PingActor extends Actor with ExaPersistentActor with ActorLogging {
  import PingActor._


  override def persistenceId: String = entryName+"-"+entryId
  var counter = 0

  private def update: (Event => Unit) =  {
    case Increment(c) => counter = counter + c
  }

  def receiveEvent: Receive = {
    case event: Increment =>
      println("recovering11..."+event)
      update(event)
      println("after rec counter "+counter)
  }


  override def receiveCommand: Receive = {
    case Added(c) =>
      println("in actor..")
      println("persistenceId>> "+persistenceId)
      log.info("In PingActor - starting ping-pong")
      println("counter>>"+counter)

      persist(Increment(c))(update)
      println("persist counter"+counter)
      sender() ! PingMessage("1 added ping")

  }
}

object PingActor {
  val props = Props[PingActor]
  case object Initialize
  case class PingMessage(text: String)
}