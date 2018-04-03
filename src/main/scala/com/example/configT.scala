//package com.example
//import com.typesafe.config.ConfigException.Missing
//import com.typesafe.config._
//
//trait configT {
//
//  private def loadConfig(name : String) = {
//    println("loading..."+name)
//ConfigFactory.load(name)
//    //ConfigFactory.parseResources(name).resolve()
//  }
//
//  private def num(i:Int) = {
//    println("loading...")
//    i
//  }
//
//  var config :(Config, Int) = (loadConfig("application.conf"), num(1))
//
//  def refreshConfig(path: String) = {
//    println("refreshing.."+path)
//    println("file.aa.."+new File(path).isFile)
//    //ConfigFactory.invalidateCaches();
//    //config = (loadConfig("update.conf"), num(2))
//    ConfigFactory.invalidateCaches()
//    config = (loadConfig("application.conf"), num(2))
//
//    //config = (ConfigFactory.parseFile(new File(path)).resolve(), num(2))
//
//  }
//
//
//
//  def getConfig: (Config, Int) = (config._1, config._2)
//
//}
//
//object appConfig extends configT
//
//
