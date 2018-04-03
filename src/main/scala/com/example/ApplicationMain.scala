package com.example

import akka.actor.{ActorSystem, Props}
import kamon.Kamon
import kamon.prometheus.PrometheusReporter



final case class ForIdentifier(id: String, msg: Any)
object ApplicationMain extends App {
  implicit val numberOfShards: Int = 100



  //SystemMetrics.startCollecting()

  //Kamon.addReporter(new ZipkinReporter())
  //Kamon.addReporter(SimpleStatsDMetricsSender.)
  Kamon.loadReportersFromConfig()
  Kamon.addReporter(new PrometheusReporter())
  val system = ActorSystem("MyActorSystem")


  /*val config = ConfigFactory.load

  val p = config.getString("akka.actor.provider")
  val newConfig = config.withValue("akka.actor.provider", ConfigValueFactory.fromAnyRef("diffrentval"))
  val p1 = newConfig.getString("akka.actor.provider")
  val p2 = newConfig.getString("akka.persistence.journal.plugin")*/


 // Kamon.addReporter(new ZipkinReporter())
 // Kamon.addReporter(new Jaeger())


 /* val pingRegion = ClusterSharding(system).start(
    typeName = "SupervisedCounter",
    entityProps = Props(new PingActor()),
    settings = ClusterShardingSettings(system),
    extractEntityId =  {
      case ForIdentifier(id, cmd) ⇒ (id, cmd)
    },
    extractShardId = {
      case ForIdentifier(id, _) ⇒ getShardId(id)
    })*/



  val pingRegion = system.actorOf(Props[PingActor])
  //Kamon.histogram("my-histogram").record(100)

  println("about to send msg for ping..")

    /*Kamon.withContextKey(, Some("1234")) {
    pingRegion ! "Some Message"
  }*/


  pingRegion ! Added(2)
  Thread.sleep(200)
  pingRegion ! Added(4)
  pingRegion ! Added(4)
  pingRegion ! Added(4)
  Thread.sleep(200)
  pingRegion ! Added(4)
  pingRegion ! Added(4)
  Thread.sleep(200)
  pingRegion ! Added(4)
  Thread.sleep(200)



  pingRegion ! Added(13)
  Thread.sleep(400)
  pingRegion ! Added(6)
  Thread.sleep(200)
  pingRegion ! Added(9)
  Thread.sleep(200)
  pingRegion ! Added(10)
  Thread.sleep(200)
  pingRegion ! Added(11)
  Thread.sleep(200)
  pingRegion ! Added(12)
  Thread.sleep(200)
  pingRegion ! Added(13)
  Thread.sleep(200)
  pingRegion ! Added(14)
  Thread.sleep(200)
  pingRegion ! Added(15)
  Thread.sleep(400)
  pingRegion ! Added(13)
  Thread.sleep(400)
  //pingRegion ! ForIdentifier("1", Added(2))
  //pingRegion ! ForIdentifier("1", Added(2))
  //pingRegion ! ForIdentifier("1", Added(2))
  //pingRegion ! Subtracted(9)
  //pingRegion ! ForIdentifier("1", Added(2))
  //pingRegion ! ForIdentifier("1", Added(2))
  //Kamon.tracer.buildSpan("event fired.. add")
//  Kamon.counter("some event")


  pingRegion ! Subtracted(10)
  pingRegion ! Subtracted(11)
  pingRegion ! Subtracted(11)
  pingRegion ! Subtracted(11)

 // Kamon.tracer.buildSpan("event fired.. add11")



  val myHistogram = Kamon.histogram("my.histogram")
  val myCounter = Kamon.counter(system.name)
  val myTaggedCounter = Kamon.counter("my.tagged.counter").refine("env" -> "test")

  //myHistogram.record(42)
  //myHistogram.record(50)
  myCounter.increment()
  myTaggedCounter.increment()



    //Kamon.counter("onnnn",  )

  /*pingRegion ! ForIdentifier("1", Added(2))
  pingRegion ! ForIdentifier("1", Added(2))
  pingRegion ! ForIdentifier("1", Added(2))
  pingRegion ! ForIdentifier("1", Added(2))
  Thread sleep 200
  pingRegion ! ForIdentifier("1", Added(2))
  pingRegion ! ForIdentifier("1", Added(2))
  pingRegion ! ForIdentifier("1", Added(2))
  Thread sleep 100
  pingRegion ! ForIdentifier("1", Added(2))*/



  //Kamon.addReporter(new KaminoReporter())
  //Kamon.addReporter(new KaminoTracingReporter())

  //pingRegion ! ForIdentifier("1111", "")

  /*println("about to send msg for pong..")
  pongRegion ! ForIdentifier("2", Subtracted(1))

*/

 // Kamon.addReporter(new PrometheusReporter())
  Thread sleep 30000
  //system.terminate()

  def getShardId(entityId: String)(implicit numberOfShards: Int) : String ={
    val a = (math.abs(entityId.hashCode) % numberOfShards).toString
    a
  }
}