name := """akka-sample"""

version := "1.0"

scalaVersion := "2.11.11"

resolvers += Resolver.bintrayRepo("kamon-io", "sbt-plugins")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.4" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.typesafe.akka" %% "akka-cluster-sharding" % "2.5.8",



  "io.kamon" %% "kamon-core" % "1.0.0",
  "io.kamon" %% "kamon-akka-2.5" % "1.0.0",
  "io.kamon" %% "kamon-prometheus" % "1.0.0",
  "io.kamon" %% "kamon-zipkin" % "1.0.0",
  "io.kamon" %% "kamon-jaeger" % "1.0.0",
  "io.kamon" %% "kamon-statsd" % "0.6.7",
  "io.kamon" %% "kamino-reporter" % "1.0.0"
)

//addSbtPlugin("aspectj" % "aspectjweaver" % "1.5.4")
//libraryDependencies += "org.aspectj" % "aspectjweaver" % "1.8.6"

fork in run := true