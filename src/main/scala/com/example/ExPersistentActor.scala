//package com.example
//
//import akka.persistence.{PersistentActor, RecoveryCompleted}
//
////case class Evt(data: String)
////case class Cmd(data: String)
//
//// **Problem with huge data**
//// persistAll - Max capacity, batchSize - we can specify
//// Incoming messages - Stash message capacity. - we can configure max size in config.
//
//trait ExaPersistentActor extends PersistentActor {
//
//  val entryName: String = self.path.parent.name
//  val entryId: String = self.path.name
//  val privateKey:String
//  var transformedEvents: List[Any] = List.empty[Any]
//
//  def emptyEventHandler(event: Any): Unit = {}
//  def deleteEvents(lastSequence: Any): Unit = {
//    println("deleting>>"+lastSequence)
//    deleteMessages(lastSequence.asInstanceOf[Long])
//  }
//
//
//  def receiveEvent: Receive
//  def receiveRecover: Receive = {
//    case RecoveryCompleted ⇒ {
//      println("lastSequenceNr>>"+lastSequenceNr)
//      val oldEventsNumber = lastSequenceNr
//      //println("New event about to store  ::>>"+encryptedEvents)
//      val enc = transformedEvents.map(Encryption.encrypt(privateKey, _))
//
//      //TODO: Check number of objects in persistent store, and lastSequenceNr, if both are same, now perform persist,
//      //TODO: if both number are not same, skip persist all.
//      /*persistAll[Any](enc){e =>
//        println("oldEventsNumber>>"+oldEventsNumber)
//        //TODO: once opr persist done, now delete previous messages
//        deleteEvents(oldEventsNumber)
//      }*/
//    } //deleteMessages()
//    //persistAll()
//    case event: Increment =>  receiveEvent(event)
//    case a: Array[Byte]  =>
//      val dec = Encryption.decrypt(privateKey, a)
//      //perform Transformation
//      val b = dec.asInstanceOf[Increment].copy(counter = 101)
//
//      //first clean data table, then write transformed data
//      transformedEvents = transformedEvents :+ b //TODO: need persistent storage,like new actor, redis with AOF, etc.
//
//      println("recoveredEvent>>"+dec)
//      receiveEvent(dec)
//  }
//
//
//  /*def receiveRecover: Receive = {
//    case event: Increment =>
//      receiveEvent(event)
//    case a: Array[Byte]  =>
//      val dec = Encryption.decrypt(privateKey, a)
//      receiveEvent(dec)
//  }*/
//
//
//  //def writeWithoutApply(evt: Array[Byte]): Unit = persist(evt)(emptyEventHandler)
//  def writeWithoutApply(evt: Array[Byte]): Unit = persistAsync(evt)(emptyEventHandler)
//
//
//}
