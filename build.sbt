name := """akka-sample"""

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.4" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.typesafe.akka" %% "akka-persistence" % "2.5.4",
  "org.iq80.leveldb"  % "leveldb" % "0.7",
  "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8",
  "com.typesafe.akka" %% "akka-cluster-sharding" % "2.5.8",
  "com.typesafe.akka" %% "akka-persistence-query" % "2.5.8",
  "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.253",
  "com.typesafe.akka" %% "akka-persistence-dynamodb" % "1.1.0",
  "com.typesafe.akka" %% "akka-persistence-query" % "2.5.8"
)


fork in run := true