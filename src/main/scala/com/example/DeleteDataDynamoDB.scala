/*
package com.example


import scala.util.parsing.json.JSON
import scala.xml._


object DeleteDataDynamoDB extends App{
  val xml = XML.loadFile("/Users/ashokwaghmare/Desktop/scan-data-10-xml.xml")
    ///println("json>> "+source)
  println("jn>> "+(xml \\ "item"))
  val apr = (xml \\ "item" \\ "par" \\ "@value").toList
  val num = (xml \\ "item" \\ "num" \\ "@value" text).map(_.toInt).toList

  println("par>> "+apr)
  println("num>> "+num)
  println("zip>>" +apr.zip(num).filter(t => t._2>50).map(t => t._1).distinct.size)
  //println("zip>>" +apr.zip(num).toMap)

}
*/
