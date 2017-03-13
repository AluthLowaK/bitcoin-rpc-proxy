package org.gnuzero

import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

// domain model
final case class Wallet(name: String, id: Long)

// collect your json format instances into a support trait:
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat = jsonFormat2(Item)
  implicit val orderFormat = jsonFormat1(Order) // contains List[Item]
}

// use it wherever json (un)marshalling is needed
class BitcoinProxy extends Directives with JsonSupport {
  // format: OFF
  val route =
      post {

      }
  // format: ON
}
