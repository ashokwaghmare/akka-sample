package com.example

import akka.persistence.PersistentActor

//case class Evt(data: String)
//case class Cmd(data: String)

trait ExaPersistentActor extends PersistentActor {

  val entryName: String = self.path.parent.name
  val entryId: String = self.path.name

  def receiveEvent: Receive
  def receiveRecover: Receive = {
    case event: Increment =>
      receiveEvent(event)
  }

}
