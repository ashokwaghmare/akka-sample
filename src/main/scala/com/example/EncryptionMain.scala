//package com.example
//
//import akka.actor.{ActorSystem, Props}
//import akka.cluster.sharding._
//import akka.cluster.singleton._
//
//object EncryptionMain extends App {
//  val enc = Encryption.encrypt("private", Increment(2))
//  println("enc>> "+enc)
//  val dec = Encryption.decrypt("private", enc)
//  println("dcy>> "+dec)
//
//}