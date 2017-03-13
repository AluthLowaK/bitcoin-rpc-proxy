package org.gnuzero

import org.gnuzero.bitcoin._
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._
import scala.concurrent.Future
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn

// domain model
// collect your json format instances into a support trait:
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat = jsonFormat2(Wallet)
}

case class Wallet(name: String, id: Long)



// use it wherever json (un)marshalling is needed
object BitcoinProxy extends Directives with JsonSupport {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher


  def main(args: Array[String]): Unit = {



    val route =
      path("wallet" / "create") {
        post {
          complete(RpcService.createWallet())
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
  }

  object RpcService {

    def createWallet():Future[Wallet] = {
      implicit val jsonrpc = new JSONRPC("http://54.235.237.34:49568", "coind", "dnioc")
      val addr = BitcoinRPC.getnewaddressForAccount("fooo") match {
        case Right(y:String) => y
      }
      Future {
        Wallet(name = addr, id = 123L)
      }
    }
  }

}


