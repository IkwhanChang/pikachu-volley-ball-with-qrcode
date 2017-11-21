package models

import akka.actor._
import scala.concurrent.duration._
import scala.language.postfixOps

import play.api._
import play.api.libs.json._
import play.api.libs.iteratee._
import play.api.libs.concurrent._

import akka.util.Timeout
import akka.pattern.ask

import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits._
/*
object Robot {

  def apply(chatRoom: ActorRef) {

    // Create an Iteratee that logs all messages to the console.
    val loggerIteratee = Iteratee.foreach[JsValue](event => Logger("robot").info(event.toString))

    implicit val timeout = Timeout(1 second)
    // Make the robot join the room
    chatRoom ? (Join("Robot")) map {
      case Connected(robotChannel) =>
        // Apply this Enumerator on the logger.
        robotChannel |>> loggerIteratee
    }

    // Make the robot talk every 30 seconds
    Akka.system.scheduler.schedule(
      30 seconds,
      30 seconds,
      chatRoom,
      Talk("Robot", "I'm still alive")
    )
  }

}
*/
object ChatRoom {
  
  implicit val timeout = Timeout(1 second)
  
  lazy val default = {
    val roomActor = Akka.system.actorOf(Props[ChatRoom])
    
    // Create a bot user (just for fun)
    //Robot(roomActor)
    
    roomActor
  }

  def join(token:String):scala.concurrent.Future[(Iteratee[JsValue,_],Enumerator[JsValue])] = {

    (default ? Join(token)).map {
      
      case Connected(enumerator) => 
      
        // Create an Iteratee to consume the feed
        val iteratee = Iteratee.foreach[JsValue] { event =>
          default ! JoinRoom(token)
        }.map { _ =>
          default ! Quit(token)
        }

        (iteratee,enumerator)
        
      case CannotConnect(error) => 
      
        // Connection error

        // A finished Iteratee sending EOF
        val iteratee = Done[JsValue,Unit]((),Input.EOF)

        // Send an error and close the socket
        val enumerator =  Enumerator[JsValue](JsObject(Seq("error" -> JsString(error)))).andThen(Enumerator.enumInput(Input.EOF))
        
        (iteratee,enumerator)
         
    }

  }

  def makeRoom(room:Room):scala.concurrent.Future[(Iteratee[JsValue,_],Enumerator[JsValue])] = {

    (default ? MakeRoom(room)).map {

      case Connected(enumerator) =>

        // Create an Iteratee to consume the feed
        val iteratee = Iteratee.foreach[JsValue] { event =>
          //default ! Talk(token, (event \ "text").as[String])
        }.map { _ =>
          //default ! Quit(token)
        }

        (iteratee,enumerator)

      case CannotConnect(error) =>

        // Connection error

        // A finished Iteratee sending EOF
        val iteratee = Done[JsValue,Unit]((),Input.EOF)

        // Send an error and close the socket
        val enumerator =  Enumerator[JsValue](JsObject(Seq("error" -> JsString(error)))).andThen(Enumerator.enumInput(Input.EOF))

        (iteratee,enumerator)

    }

  }

  def quitRoom(seq_room:Long):scala.concurrent.Future[(Iteratee[JsValue,_],Enumerator[JsValue])] = {

    (default ? QuitRoom(seq_room)).map {

      case Connected(enumerator) =>

        // Create an Iteratee to consume the feed
        val iteratee = Iteratee.foreach[JsValue] { event =>
          //default ! Talk(token, (event \ "text").as[String])
        }.map { _ =>
          //default ! Quit(token)
        }

        (iteratee,enumerator)

      case CannotConnect(error) =>

        // Connection error

        // A finished Iteratee sending EOF
        val iteratee = Done[JsValue,Unit]((),Input.EOF)

        // Send an error and close the socket
        val enumerator =  Enumerator[JsValue](JsObject(Seq("error" -> JsString(error)))).andThen(Enumerator.enumInput(Input.EOF))

        (iteratee,enumerator)

    }

  }
  
}

class ChatRoom extends Actor {
  
  var members = Set.empty[String]
  val (chatEnumerator, chatChannel) = Concurrent.broadcast[JsValue]

  def receive = {
    
    case Join(token) => {
      Users.setUserStatusByToken(token,1)
      if(members.contains(token)) {
        sender ! CannotConnect("This username is already used")
      } else {
        members = members + token
        sender ! Connected(chatEnumerator)
        self ! NotifyJoin(token)
      }
    }

    case QuitRoom(seq_room) => {
      self ! notifyAll_Quitroom(seq_room)
    }

    case JoinRoom(token) => {
      Users.setUserStatusByToken(token,2)
      self ! notifyAll("joinRoom",Users.getUserByToken(token))
    }

    case MakeRoom(room) => {
      Users.setUserStatusByToken(room.id_owner,2)
      self ! notifyAll_Makeroom(room)
    }

    case NotifyJoin(token) => {
      notifyAll("join", Users.getUserByToken(token))
    }

    
    case Quit(token) => {
      members = members - token
      Users.setUserStatusByToken(token,0)
      notifyAll("quit", Users.getUserByToken(token))
    }
    
  }
  
  def notifyAll(kind: String, user:User) {
    val msg = JsObject(
      Seq(
        "Action" -> JsString(kind),
        "token" -> JsString(user.token),
        "name" -> JsString(user.name),
        "seq" -> JsNumber(user.seq.get)
      )
    )
    chatChannel.push(msg)
  }

  def notifyAll_Makeroom(room:Room) {
    val msg = JsObject(
      Seq(
        "Action" -> JsString("makeRoom"),
        "title" -> JsString(room.title),
        "time" -> JsNumber(room.time),
        "seq" -> JsNumber(room.seq.get),
        "owner_id" -> JsString(room.id_owner),
        "owner" -> JsString(room.owner.name)
      )
    )
    chatChannel.push(msg)
  }

  def notifyAll_Quitroom(seq_room:Long) {
    val msg = JsObject(
      Seq(
        "Action" -> JsString("quitRoom"),
        "seq" -> JsNumber(seq_room)
      )
    )
    chatChannel.push(msg)
  }
  
}

case class QuitRoom(seq_room:Long)
case class JoinRoom(token:String)
case class MakeRoom(room:Room)
case class Join(token:String)
case class Quit(username: String)
case class Talk(username: String, text: String)
case class NotifyJoin(username: String)

case class Connected(enumerator:Enumerator[JsValue])
case class CannotConnect(msg: String)
