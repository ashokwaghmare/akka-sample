package com.example

import akka.actor.{ActorSystem, Props}
import akka.cluster.sharding._
import akka.cluster.singleton._

final case class ForIdentifier(id: String, msg: Any)
object ApplicationMain extends App {
  implicit val numberOfShards: Int = 100

  val system = ActorSystem("MyActorSystem")
  //val pingActor = system.actorOf(PingActor.props, "pingActor")
  //val pongActor = system.actorOf(PongActor.props, "pongActor")

  val pingRegion = ClusterSharding(system).start(
    typeName = "SupervisedCounter",
    entityProps = Props(new PingActor()),
    settings = ClusterShardingSettings(system),
    extractEntityId =  {
      case ForIdentifier(id, cmd) ⇒ (id, cmd)
    },
    extractShardId = {
      case ForIdentifier(id, _) ⇒ getShardId(id)
    })

  val pongRegion = ClusterSharding(system).start(
    typeName = "SupervisedCounter1",
    entityProps = Props(new PongActor()),
    settings = ClusterShardingSettings(system),
    extractEntityId =  {
      case ForIdentifier(id, cmd) ⇒ (id, cmd)
    },
    extractShardId = {
      case ForIdentifier(id, _) ⇒ getShardId(id)
    })


  println("about to send msg for ping..")
  pingRegion ! ForIdentifier("1", Added(1))

  println("about to send msg for pong..")
  pongRegion ! ForIdentifier("2", Subtracted(1))



  Thread sleep 10000
  system.terminate()

  def getShardId(entityId: String)(implicit numberOfShards: Int) : String =
    (math.abs(entityId.hashCode) % numberOfShards).toString
}