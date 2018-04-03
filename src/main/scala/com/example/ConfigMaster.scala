//package com.example
//
//import akka.actor.{Actor, ActorRef, Props}
//import akka.cluster.ClusterEvent.{MemberExited, MemberRemoved, MemberUp, UnreachableMember}
//
//case object RefreshConfig
//case object ConfigNodeRegistration
//
//object ConfigManager {
//  val name: String = "config-manager"
//  def props = Props(new ConfigManager)
//}
//
//class ConfigManager extends Actor {
//
//  var nodes = IndexedSeq.empty[ActorRef]
//
//  def receive = {
//    case RefreshConfig =>
//      println("sending to nodes..")
//      nodes.foreach(node => node ! RefreshConfig)
//
//    case ConfigNodeRegistration if !nodes.contains(sender()) =>
//      context watch sender()
//      nodes = nodes :+ sender()
//
//    case MemberUp(member) =>
//      println("memeber joined "+member.address)
//    //Logger.info("Member joined: {}", member.address)
//
//    case MemberRemoved(member, previousState) =>
//      println("memeber removed "+member.address)
//
//    case MemberExited(member)  =>
//      println("memeber exited "+member.address)
//
//    case UnreachableMember(member)  =>
//      println("memeber unreachable "+member.address)
//
//    case _ => println("unhandled..")
//
//  }
//
//}
