package com.example

import akka.actor
import akka.actor.{Actor, ActorInitializationException, DeathPactException, OneForOneStrategy, Props, SupervisorStrategy}

class CounterSupervisor extends Actor {
  val counter = context.actorOf(Props[PingActor], "theCounter")

  override val supervisorStrategy = OneForOneStrategy() {
    case _: IllegalArgumentException     ⇒ SupervisorStrategy.Resume
    case _: ActorInitializationException ⇒ SupervisorStrategy.Stop
    case _: DeathPactException           ⇒ SupervisorStrategy.Stop
    case _: Exception                    ⇒ SupervisorStrategy.Restart
  }

  def receive = {
    case msg ⇒ counter forward msg
  }
}
