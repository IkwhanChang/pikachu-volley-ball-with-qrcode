// @SOURCE:/Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/conf/routes
// @HASH:491a63b6601dcc7381f548032fd6be95948483ee
// @DATE:Mon Jun 02 14:28:32 KST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_index1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Application_privacy2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Privacy"))))
        

// @LINE:10
private[this] lazy val controllers_Application_privacy3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Privacy"))))
        

// @LINE:12
private[this] lazy val controllers_Application_controller4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Controller"))))
        

// @LINE:13
private[this] lazy val controllers_Application_controller5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Controller"))))
        

// @LINE:17
private[this] lazy val controllers_User_addUser6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/addUser"))))
        

// @LINE:18
private[this] lazy val controllers_User_getUser7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/getUser"))))
        

// @LINE:19
private[this] lazy val controllers_User_setUserCurrentRoom8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/setUserCurrentRoom"))))
        

// @LINE:20
private[this] lazy val controllers_User_setUserStatusByToken9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/setUserStatusByToken"))))
        

// @LINE:21
private[this] lazy val controllers_User_setUserXY10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/setUserXY"))))
        

// @LINE:22
private[this] lazy val controllers_User_JumpUser11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/JumpUser"))))
        

// @LINE:23
private[this] lazy val controllers_User_ShootUser12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("User/ShootUser"))))
        

// @LINE:28
private[this] lazy val controllers_Application_chatRoom13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("room"))))
        

// @LINE:29
private[this] lazy val controllers_Application_chat14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("room/chat"))))
        

// @LINE:30
private[this] lazy val controllers_Application_chatRoomJs15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/chatroom.js"))))
        

// @LINE:32
private[this] lazy val controllers_Application_chatRoom16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("room"))))
        

// @LINE:33
private[this] lazy val controllers_Application_chat17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("room/chat"))))
        

// @LINE:34
private[this] lazy val controllers_Application_chatRoomJs18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/chatroom.js"))))
        

// @LINE:37
private[this] lazy val controllers_Application_gameRoom19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game"))))
        

// @LINE:38
private[this] lazy val controllers_Application_game20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("game/chat"))))
        

// @LINE:39
private[this] lazy val controllers_Application_gameRoomJS21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/gameroom.js"))))
        

// @LINE:41
private[this] lazy val controllers_Room_addRoom22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Room/addRoom"))))
        

// @LINE:42
private[this] lazy val controllers_Room_delRoom23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Room/delRoom"))))
        

// @LINE:45
private[this] lazy val controllers_Room_getRooms24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Room/getRooms"))))
        

// @LINE:46
private[this] lazy val controllers_Room_getRooms25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Room/getRooms"))))
        

// @LINE:47
private[this] lazy val controllers_Room_getPlayersProfile26 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Room/getPlayersProfile"))))
        

// @LINE:51
private[this] lazy val controllers_Assets_at27 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:54
private[this] lazy val controllers_Application_javascriptRoutes28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("javascriptRoutes"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""POST""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Privacy""","""controllers.Application.privacy"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Privacy""","""controllers.Application.privacy"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Controller""","""controllers.Application.controller"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Controller""","""controllers.Application.controller"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/addUser""","""controllers.User.addUser(name:String, email:String, pic_url:String, token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/getUser""","""controllers.User.getUser(token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/setUserCurrentRoom""","""controllers.User.setUserCurrentRoom(seq_room:Int, token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/setUserStatusByToken""","""controllers.User.setUserStatusByToken(status:Int, token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/setUserXY""","""controllers.User.setUserXY(token:String, x:Int, y:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/JumpUser""","""controllers.User.JumpUser(token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """User/ShootUser""","""controllers.User.ShootUser(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """room""","""controllers.Application.chatRoom(token:Option[String])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """room/chat""","""controllers.Application.chat(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/chatroom.js""","""controllers.Application.chatRoomJs(token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """room""","""controllers.Application.chatRoom(token:Option[String])"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """room/chat""","""controllers.Application.chat(token:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/chatroom.js""","""controllers.Application.chatRoomJs(token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game""","""controllers.Application.gameRoom(token:String, seq_room:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """game/chat""","""controllers.Application.game(token:String, seq_room:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/gameroom.js""","""controllers.Application.gameRoomJS(token:String, seq_room:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Room/addRoom""","""controllers.Room.addRoom(title:String, time:Int, token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Room/delRoom""","""controllers.Room.delRoom(seq_room:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Room/getRooms""","""controllers.Room.getRooms"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Room/getRooms""","""controllers.Room.getRooms"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Room/getPlayersProfile""","""controllers.Room.getPlayersProfile(seq:Int, token:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascriptRoutes""","""controllers.Application.javascriptRoutes""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_index1(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Application_privacy2(params) => {
   call { 
        invokeHandler(controllers.Application.privacy, HandlerDef(this, "controllers.Application", "privacy", Nil,"GET", """""", Routes.prefix + """Privacy"""))
   }
}
        

// @LINE:10
case controllers_Application_privacy3(params) => {
   call { 
        invokeHandler(controllers.Application.privacy, HandlerDef(this, "controllers.Application", "privacy", Nil,"POST", """""", Routes.prefix + """Privacy"""))
   }
}
        

// @LINE:12
case controllers_Application_controller4(params) => {
   call { 
        invokeHandler(controllers.Application.controller, HandlerDef(this, "controllers.Application", "controller", Nil,"GET", """""", Routes.prefix + """Controller"""))
   }
}
        

// @LINE:13
case controllers_Application_controller5(params) => {
   call { 
        invokeHandler(controllers.Application.controller, HandlerDef(this, "controllers.Application", "controller", Nil,"POST", """""", Routes.prefix + """Controller"""))
   }
}
        

// @LINE:17
case controllers_User_addUser6(params) => {
   call(params.fromQuery[String]("name", None), params.fromQuery[String]("email", None), params.fromQuery[String]("pic_url", None), params.fromQuery[String]("token", None)) { (name, email, pic_url, token) =>
        invokeHandler(controllers.User.addUser(name, email, pic_url, token), HandlerDef(this, "controllers.User", "addUser", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"POST", """User""", Routes.prefix + """User/addUser"""))
   }
}
        

// @LINE:18
case controllers_User_getUser7(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.User.getUser(token), HandlerDef(this, "controllers.User", "getUser", Seq(classOf[String]),"POST", """""", Routes.prefix + """User/getUser"""))
   }
}
        

// @LINE:19
case controllers_User_setUserCurrentRoom8(params) => {
   call(params.fromQuery[Int]("seq_room", None), params.fromQuery[String]("token", None)) { (seq_room, token) =>
        invokeHandler(controllers.User.setUserCurrentRoom(seq_room, token), HandlerDef(this, "controllers.User", "setUserCurrentRoom", Seq(classOf[Int], classOf[String]),"POST", """""", Routes.prefix + """User/setUserCurrentRoom"""))
   }
}
        

// @LINE:20
case controllers_User_setUserStatusByToken9(params) => {
   call(params.fromQuery[Int]("status", None), params.fromQuery[String]("token", None)) { (status, token) =>
        invokeHandler(controllers.User.setUserStatusByToken(status, token), HandlerDef(this, "controllers.User", "setUserStatusByToken", Seq(classOf[Int], classOf[String]),"POST", """""", Routes.prefix + """User/setUserStatusByToken"""))
   }
}
        

// @LINE:21
case controllers_User_setUserXY10(params) => {
   call(params.fromQuery[String]("token", None), params.fromQuery[Int]("x", None), params.fromQuery[Int]("y", None)) { (token, x, y) =>
        invokeHandler(controllers.User.setUserXY(token, x, y), HandlerDef(this, "controllers.User", "setUserXY", Seq(classOf[String], classOf[Int], classOf[Int]),"POST", """""", Routes.prefix + """User/setUserXY"""))
   }
}
        

// @LINE:22
case controllers_User_JumpUser11(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.User.JumpUser(token), HandlerDef(this, "controllers.User", "JumpUser", Seq(classOf[String]),"POST", """""", Routes.prefix + """User/JumpUser"""))
   }
}
        

// @LINE:23
case controllers_User_ShootUser12(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.User.ShootUser(token), HandlerDef(this, "controllers.User", "ShootUser", Seq(classOf[String]),"POST", """""", Routes.prefix + """User/ShootUser"""))
   }
}
        

// @LINE:28
case controllers_Application_chatRoom13(params) => {
   call(params.fromQuery[Option[String]]("token", None)) { (token) =>
        invokeHandler(controllers.Application.chatRoom(token), HandlerDef(this, "controllers.Application", "chatRoom", Seq(classOf[Option[String]]),"GET", """Chat""", Routes.prefix + """room"""))
   }
}
        

// @LINE:29
case controllers_Application_chat14(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.Application.chat(token), HandlerDef(this, "controllers.Application", "chat", Seq(classOf[String]),"GET", """""", Routes.prefix + """room/chat"""))
   }
}
        

// @LINE:30
case controllers_Application_chatRoomJs15(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.Application.chatRoomJs(token), HandlerDef(this, "controllers.Application", "chatRoomJs", Seq(classOf[String]),"GET", """""", Routes.prefix + """assets/javascripts/chatroom.js"""))
   }
}
        

// @LINE:32
case controllers_Application_chatRoom16(params) => {
   call(params.fromQuery[Option[String]]("token", None)) { (token) =>
        invokeHandler(controllers.Application.chatRoom(token), HandlerDef(this, "controllers.Application", "chatRoom", Seq(classOf[Option[String]]),"POST", """""", Routes.prefix + """room"""))
   }
}
        

// @LINE:33
case controllers_Application_chat17(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.Application.chat(token), HandlerDef(this, "controllers.Application", "chat", Seq(classOf[String]),"POST", """""", Routes.prefix + """room/chat"""))
   }
}
        

// @LINE:34
case controllers_Application_chatRoomJs18(params) => {
   call(params.fromQuery[String]("token", None)) { (token) =>
        invokeHandler(controllers.Application.chatRoomJs(token), HandlerDef(this, "controllers.Application", "chatRoomJs", Seq(classOf[String]),"POST", """""", Routes.prefix + """assets/javascripts/chatroom.js"""))
   }
}
        

// @LINE:37
case controllers_Application_gameRoom19(params) => {
   call(params.fromQuery[String]("token", None), params.fromQuery[Long]("seq_room", None)) { (token, seq_room) =>
        invokeHandler(controllers.Application.gameRoom(token, seq_room), HandlerDef(this, "controllers.Application", "gameRoom", Seq(classOf[String], classOf[Long]),"GET", """Room""", Routes.prefix + """game"""))
   }
}
        

// @LINE:38
case controllers_Application_game20(params) => {
   call(params.fromQuery[String]("token", None), params.fromQuery[Long]("seq_room", None)) { (token, seq_room) =>
        invokeHandler(controllers.Application.game(token, seq_room), HandlerDef(this, "controllers.Application", "game", Seq(classOf[String], classOf[Long]),"GET", """""", Routes.prefix + """game/chat"""))
   }
}
        

// @LINE:39
case controllers_Application_gameRoomJS21(params) => {
   call(params.fromQuery[String]("token", None), params.fromQuery[Long]("seq_room", None)) { (token, seq_room) =>
        invokeHandler(controllers.Application.gameRoomJS(token, seq_room), HandlerDef(this, "controllers.Application", "gameRoomJS", Seq(classOf[String], classOf[Long]),"GET", """""", Routes.prefix + """assets/javascripts/gameroom.js"""))
   }
}
        

// @LINE:41
case controllers_Room_addRoom22(params) => {
   call(params.fromQuery[String]("title", None), params.fromQuery[Int]("time", None), params.fromQuery[String]("token", None)) { (title, time, token) =>
        invokeHandler(controllers.Room.addRoom(title, time, token), HandlerDef(this, "controllers.Room", "addRoom", Seq(classOf[String], classOf[Int], classOf[String]),"GET", """""", Routes.prefix + """Room/addRoom"""))
   }
}
        

// @LINE:42
case controllers_Room_delRoom23(params) => {
   call(params.fromQuery[Int]("seq_room", None)) { (seq_room) =>
        invokeHandler(controllers.Room.delRoom(seq_room), HandlerDef(this, "controllers.Room", "delRoom", Seq(classOf[Int]),"GET", """""", Routes.prefix + """Room/delRoom"""))
   }
}
        

// @LINE:45
case controllers_Room_getRooms24(params) => {
   call { 
        invokeHandler(controllers.Room.getRooms, HandlerDef(this, "controllers.Room", "getRooms", Nil,"POST", """""", Routes.prefix + """Room/getRooms"""))
   }
}
        

// @LINE:46
case controllers_Room_getRooms25(params) => {
   call { 
        invokeHandler(controllers.Room.getRooms, HandlerDef(this, "controllers.Room", "getRooms", Nil,"GET", """""", Routes.prefix + """Room/getRooms"""))
   }
}
        

// @LINE:47
case controllers_Room_getPlayersProfile26(params) => {
   call(params.fromQuery[Int]("seq", None), params.fromQuery[String]("token", None)) { (seq, token) =>
        invokeHandler(controllers.Room.getPlayersProfile(seq, token), HandlerDef(this, "controllers.Room", "getPlayersProfile", Seq(classOf[Int], classOf[String]),"POST", """""", Routes.prefix + """Room/getPlayersProfile"""))
   }
}
        

// @LINE:51
case controllers_Assets_at27(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:54
case controllers_Application_javascriptRoutes28(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes, HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """ Javascript Route""", Routes.prefix + """javascriptRoutes"""))
   }
}
        
}

}
     