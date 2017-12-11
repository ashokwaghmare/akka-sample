package com.example

import akka.persistence.PersistentActor

//case class Evt(data: String)
//case class Cmd(data: String)

trait ExaPersistentActor extends PersistentActor {

  val entryName: String = self.path.parent.name
  val entryId: String = self.path.name
  val privateKey:String

  def receiveEvent: Receive
  def receiveRecover: Receive = {
    case event: Increment =>
      receiveEvent(event)
    case a: Array[Byte]  =>
      receiveEvent(Encryption.decrypt(privateKey, a))
  }

  def emptyEventHandler(event: Any): Unit = {}

  def writeWithoutApply(evt: Array[Byte]): Unit = persist(evt)(emptyEventHandler)


}
