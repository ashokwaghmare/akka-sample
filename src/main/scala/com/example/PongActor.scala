package com.example

import akka.actor.{Actor, ActorLogging, Props}
import akka.persistence.PersistentActor

class PongActor extends Actor with PersistentActor with ActorLogging {
  import PingActor._

  override def persistenceId: String = "counter-actor-1"
  var counter = 0

  private def update: (Event => Unit) =  {
    case Increment(c) => counter = c
  }

  def receiveRecover: Receive = {
    case event: Event =>
      println("recovering..."+event)
      update(event)
  }



  override def receiveCommand: Receive = {
    case Added(c) =>
      println("in actor..")
      log.info("In PingActor - starting ping-pong")
      persist(Increment(c))(update)
      sender() ! PingMessage("1 added ping")

  }
}

object PongActor {
  val props = Props[PongActor]
}
