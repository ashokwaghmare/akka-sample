//package com.example
//
//import java.util.concurrent.atomic.AtomicReference
//
//import akka.actor.ActorSystem
//import akka.http.scaladsl.Http
//import akka.stream.ActorMaterializer
//import com.typesafe.config.ConfigValueFactory
//import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
//import akka.http.scaladsl.server.Route
//import akka.http.scaladsl.server.directives.MethodDirectives.delete
//import akka.http.scaladsl.server.directives.MethodDirectives.get
//import akka.http.scaladsl.server.directives.MethodDirectives.post
//import akka.http.scaladsl.server.directives.RouteDirectives.complete
//import akka.http.scaladsl.server.directives.PathDirectives.path
//import akka.http.scaladsl.server.directives.PathDirectives.pathPrefix
//
//import scala.concurrent.duration._
//import akka.http.scaladsl.server.Directives._
//
//import scala.io.StdIn
//
//object AkkaHttpMain {
//
//    def main(args: Array[String]) {
//
//      implicit val system =  ActorSystem("MyActorSystem1")
//
//      implicit val materializer = ActorMaterializer()
//      // needed for the future flatMap/onComplete in the end
//      implicit val executionContext = system.dispatcher
//
//
//
//
//
//      def refreshConfig(path: String) = {
//        appConfig.refreshConfig(path)
//      }
//
//      val route = pathPrefix("agency") { path("hello") {
//          get {
//            complete{
//
//              HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>asa ${appConfig.getConfig._2} -- ${appConfig.getConfig._1.getString("akka.randomV")} -- " +
//                s" ${appConfig.getConfig._1.getString("akka.secondRandom")} </h1>")
//              //HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>${appConfig.config.getString("akka.actor.provider")}</h1>")
//
//            }
//          }
//        } ~ path("change") { parameters('key.as[String]) { key =>
//        complete{
//          //changeConfig("akka.actor.provider", "othervalue")
//          //changeConfig("akka.actor.provider", "ewtyuwqyti")
//          refreshConfig(key)
//          HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>config chages</h1>")
//        }
//      }
//      }
//      }
//
//      val bindingFuture = Http().bindAndHandle(route, "localhost", 8081)
//
//      println(s"Server online at http://localhost:8081/\nPress RETURN to stop...")
//      StdIn.readLine() // let it run until user presses return
//      bindingFuture
//        .flatMap(_.unbind()) // trigger unbinding from the port
//        .onComplete(_ => system.terminate()) // and shutdown when done
//    }
//
//}
