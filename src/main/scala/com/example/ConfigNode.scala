//package com.example
//
//package com.evernym.agency.common.actor
//
//import akka.actor.{Actor, Props}
//import akka.cluster.{Cluster, Member, MemberStatus}
//import akka.cluster.ClusterEvent.{CurrentClusterState, MemberUp}
//
//
//object ConfigNode {
//  def props = Props(new ConfigNode)
//}
//
//class ConfigNode extends Actor {
//  val cluster = Cluster(context.system)
//
//  override def preStart(): Unit = {
//    println("joining cluster.. ")
//    cluster.subscribe(self, classOf[MemberUp])
//  }
//  override def postStop(): Unit = cluster.unsubscribe(self)
//
//
//  def receive = {
//    case RefreshConfig =>
//      println("refreshed config..")
//      ConfigWrapper.refreshConfig
//
//    case state: CurrentClusterState =>
//      state.members.filter(_.status == MemberStatus.Up) foreach register
//
//    case MemberUp(m) => register(m)
//  }
//
//  def register(member: Member): Unit = {
//    println("registering..")
//    if (member.hasRole("frontend"))
//      getActorRefFromSelection(s"$SINGLETON_PARENT_PROXY/$CONFIG_MANAGER_ACTOR_NAME", context.system) ! ConfigNodeRegistration
//  }
//}
//
