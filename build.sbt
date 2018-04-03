
name := """akka-sample"""

version := "1.0"

scalaVersion := "2.12.2"
val akka = "2.5.9"
val akka_http = "10.0.11"

resolvers += Resolver.bintrayRepo("kamon-io", "sbt-plugins")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akka,

/*  "com.typesafe.akka" %% "akka-testkit" % "2.5.4" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",*/
  /*"com.typesafe.akka" %% "akka-cluster-sharding" % akka,
  "com.typesafe.akka" %% "akka-http"   % akka_http,
  "com.typesafe.akka" %% "akka-cluster" % "2.3.3"*/


  "io.kamon" %% "kamon-core" % "1.0.0",
  "io.kamon" %% "kamon-akka-2.5" % "1.0.0",
  "io.kamon" %% "kamon-prometheus" % "1.0.0"
/*  "io.kamon" %% "kamon-zipkin" % "1.0.0",
  "io.kamon" %% "kamon-jaeger" % "1.0.0",
  "io.kamon" %% "kamon-statsd" % "0.6.7",
  "io.kamon" %% "kamino-reporter" % "1.0.0",
  "io.kamon" %% "kamon-system-metrics" % "1.0.0"*/
)


//addSbtPlugin("aspectj" % "aspectjweaver" % "1.5.4")
//libraryDependencies += "org.aspectj" % "aspectjweaver" % "1.8.6"

//aspectjSettings

// when you call "sbt run" aspectj weaving kicks in
//javaOptions <++= AspectjKeys.weaverOptions in Aspectj
//javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true