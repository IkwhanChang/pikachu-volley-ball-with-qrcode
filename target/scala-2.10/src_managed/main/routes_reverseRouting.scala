// @SOURCE:/Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/conf/routes
// @HASH:491a63b6601dcc7381f548032fd6be95948483ee
// @DATE:Mon Jun 02 14:28:32 KST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:54
// @LINE:51
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers {

// @LINE:51
class ReverseAssets {
    

// @LINE:51
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:42
// @LINE:41
class ReverseRoom {
    

// @LINE:42
def delRoom(seq_room:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Room/delRoom" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("seq_room", seq_room)))))
}
                                                

// @LINE:47
def getPlayersProfile(seq:Int, token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Room/getPlayersProfile" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("seq", seq)), Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:46
// @LINE:45
def getRooms(): Call = {
   () match {
// @LINE:45
case () if true => Call("POST", _prefix + { _defaultPrefix } + "Room/getRooms")
                                                        
// @LINE:46
case () if true => Call("GET", _prefix + { _defaultPrefix } + "Room/getRooms")
                                                        
   }
}
                                                

// @LINE:41
def addRoom(title:String, time:Int, token:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Room/addRoom" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("title", title)), Some(implicitly[QueryStringBindable[Int]].unbind("time", time)), Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseUser {
    

// @LINE:17
def addUser(name:String, email:String, pic_url:String, token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/addUser" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)), Some(implicitly[QueryStringBindable[String]].unbind("email", email)), Some(implicitly[QueryStringBindable[String]].unbind("pic_url", pic_url)), Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:22
def JumpUser(token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/JumpUser" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:23
def ShootUser(token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/ShootUser" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:19
def setUserCurrentRoom(seq_room:Int, token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/setUserCurrentRoom" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("seq_room", seq_room)), Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:18
def getUser(token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/getUser" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:20
def setUserStatusByToken(status:Int, token:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/setUserStatusByToken" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("status", status)), Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
}
                                                

// @LINE:21
def setUserXY(token:String, x:Int, y:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "User/setUserXY" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)), Some(implicitly[QueryStringBindable[Int]].unbind("x", x)), Some(implicitly[QueryStringBindable[Int]].unbind("y", y)))))
}
                                                
    
}
                          

// @LINE:54
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:33
// @LINE:29
def chat(token:String): Call = {
   (token: @unchecked) match {
// @LINE:29
case (token) if true => Call("GET", _prefix + { _defaultPrefix } + "room/chat" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
                                                        
// @LINE:33
case (token) if true => Call("POST", _prefix + { _defaultPrefix } + "room/chat" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
                                                        
   }
}
                                                

// @LINE:32
// @LINE:28
def chatRoom(token:Option[String]): Call = {
   (token: @unchecked) match {
// @LINE:28
case (token) if true => Call("GET", _prefix + { _defaultPrefix } + "room" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("token", token)))))
                                                        
// @LINE:32
case (token) if true => Call("POST", _prefix + { _defaultPrefix } + "room" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("token", token)))))
                                                        
   }
}
                                                

// @LINE:34
// @LINE:30
def chatRoomJs(token:String): Call = {
   (token: @unchecked) match {
// @LINE:30
case (token) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/chatroom.js" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
                                                        
// @LINE:34
case (token) if true => Call("POST", _prefix + { _defaultPrefix } + "assets/javascripts/chatroom.js" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)))))
                                                        
   }
}
                                                

// @LINE:10
// @LINE:9
def privacy(): Call = {
   () match {
// @LINE:9
case () if true => Call("GET", _prefix + { _defaultPrefix } + "Privacy")
                                                        
// @LINE:10
case () if true => Call("POST", _prefix + { _defaultPrefix } + "Privacy")
                                                        
   }
}
                                                

// @LINE:38
def game(token:String, seq_room:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "game/chat" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)), Some(implicitly[QueryStringBindable[Long]].unbind("seq_room", seq_room)))))
}
                                                

// @LINE:39
def gameRoomJS(token:String, seq_room:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/gameroom.js" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)), Some(implicitly[QueryStringBindable[Long]].unbind("seq_room", seq_room)))))
}
                                                

// @LINE:37
def gameRoom(token:String, seq_room:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "game" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)), Some(implicitly[QueryStringBindable[Long]].unbind("seq_room", seq_room)))))
}
                                                

// @LINE:13
// @LINE:12
def controller(): Call = {
   () match {
// @LINE:12
case () if true => Call("GET", _prefix + { _defaultPrefix } + "Controller")
                                                        
// @LINE:13
case () if true => Call("POST", _prefix + { _defaultPrefix } + "Controller")
                                                        
   }
}
                                                

// @LINE:7
// @LINE:6
def index(): Call = {
   () match {
// @LINE:6
case () if true => Call("GET", _prefix)
                                                        
// @LINE:7
case () if true => Call("POST", _prefix)
                                                        
   }
}
                                                

// @LINE:54
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "javascriptRoutes")
}
                                                
    
}
                          
}
                  


// @LINE:54
// @LINE:51
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:51
class ReverseAssets {
    

// @LINE:51
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:42
// @LINE:41
class ReverseRoom {
    

// @LINE:42
def delRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Room.delRoom",
   """
      function(seq_room) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Room/delRoom" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("seq_room", seq_room)])})
      }
   """
)
                        

// @LINE:47
def getPlayersProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Room.getPlayersProfile",
   """
      function(seq,token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Room/getPlayersProfile" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("seq", seq), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:46
// @LINE:45
def getRooms : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Room.getRooms",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Room/getRooms"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Room/getRooms"})
      }
      }
   """
)
                        

// @LINE:41
def addRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Room.addRoom",
   """
      function(title,time,token) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Room/addRoom" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("title", title), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("time", time), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        
    
}
              

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseUser {
    

// @LINE:17
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.addUser",
   """
      function(name,email,pic_url,token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/addUser" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pic_url", pic_url), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:22
def JumpUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.JumpUser",
   """
      function(token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/JumpUser" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:23
def ShootUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.ShootUser",
   """
      function(token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/ShootUser" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:19
def setUserCurrentRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.setUserCurrentRoom",
   """
      function(seq_room,token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/setUserCurrentRoom" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("seq_room", seq_room), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:18
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.getUser",
   """
      function(token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/getUser" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:20
def setUserStatusByToken : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.setUserStatusByToken",
   """
      function(status,token) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/setUserStatusByToken" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("status", status), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
   """
)
                        

// @LINE:21
def setUserXY : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.setUserXY",
   """
      function(token,x,y) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "User/setUserXY" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("x", x), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("y", y)])})
      }
   """
)
                        
    
}
              

// @LINE:54
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:33
// @LINE:29
def chat : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.chat",
   """
      function(token) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "room/chat" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "room/chat" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
      }
   """
)
                        

// @LINE:32
// @LINE:28
def chatRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.chatRoom",
   """
      function(token) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "room" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("token", token)])})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "room" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("token", token)])})
      }
      }
   """
)
                        

// @LINE:34
// @LINE:30
def chatRoomJs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.chatRoomJs",
   """
      function(token) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/chatroom.js" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/chatroom.js" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token)])})
      }
      }
   """
)
                        

// @LINE:10
// @LINE:9
def privacy : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.privacy",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Privacy"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Privacy"})
      }
      }
   """
)
                        

// @LINE:38
def game : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.game",
   """
      function(token,seq_room) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "game/chat" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("seq_room", seq_room)])})
      }
   """
)
                        

// @LINE:39
def gameRoomJS : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.gameRoomJS",
   """
      function(token,seq_room) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/gameroom.js" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("seq_room", seq_room)])})
      }
   """
)
                        

// @LINE:37
def gameRoom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.gameRoom",
   """
      function(token,seq_room) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "game" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("seq_room", seq_room)])})
      }
   """
)
                        

// @LINE:13
// @LINE:12
def controller : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.controller",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Controller"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Controller"})
      }
      }
   """
)
                        

// @LINE:7
// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + """"})
      }
      }
   """
)
                        

// @LINE:54
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascriptRoutes"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:54
// @LINE:51
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:42
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:51
class ReverseAssets {
    

// @LINE:51
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:42
// @LINE:41
class ReverseRoom {
    

// @LINE:42
def delRoom(seq_room:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Room.delRoom(seq_room), HandlerDef(this, "controllers.Room", "delRoom", Seq(classOf[Int]), "GET", """""", _prefix + """Room/delRoom""")
)
                      

// @LINE:47
def getPlayersProfile(seq:Int, token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Room.getPlayersProfile(seq, token), HandlerDef(this, "controllers.Room", "getPlayersProfile", Seq(classOf[Int], classOf[String]), "POST", """""", _prefix + """Room/getPlayersProfile""")
)
                      

// @LINE:45
def getRooms(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Room.getRooms(), HandlerDef(this, "controllers.Room", "getRooms", Seq(), "POST", """""", _prefix + """Room/getRooms""")
)
                      

// @LINE:41
def addRoom(title:String, time:Int, token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Room.addRoom(title, time, token), HandlerDef(this, "controllers.Room", "addRoom", Seq(classOf[String], classOf[Int], classOf[String]), "GET", """""", _prefix + """Room/addRoom""")
)
                      
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseUser {
    

// @LINE:17
def addUser(name:String, email:String, pic_url:String, token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.addUser(name, email, pic_url, token), HandlerDef(this, "controllers.User", "addUser", Seq(classOf[String], classOf[String], classOf[String], classOf[String]), "POST", """User""", _prefix + """User/addUser""")
)
                      

// @LINE:22
def JumpUser(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.JumpUser(token), HandlerDef(this, "controllers.User", "JumpUser", Seq(classOf[String]), "POST", """""", _prefix + """User/JumpUser""")
)
                      

// @LINE:23
def ShootUser(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.ShootUser(token), HandlerDef(this, "controllers.User", "ShootUser", Seq(classOf[String]), "POST", """""", _prefix + """User/ShootUser""")
)
                      

// @LINE:19
def setUserCurrentRoom(seq_room:Int, token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.setUserCurrentRoom(seq_room, token), HandlerDef(this, "controllers.User", "setUserCurrentRoom", Seq(classOf[Int], classOf[String]), "POST", """""", _prefix + """User/setUserCurrentRoom""")
)
                      

// @LINE:18
def getUser(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.getUser(token), HandlerDef(this, "controllers.User", "getUser", Seq(classOf[String]), "POST", """""", _prefix + """User/getUser""")
)
                      

// @LINE:20
def setUserStatusByToken(status:Int, token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.setUserStatusByToken(status, token), HandlerDef(this, "controllers.User", "setUserStatusByToken", Seq(classOf[Int], classOf[String]), "POST", """""", _prefix + """User/setUserStatusByToken""")
)
                      

// @LINE:21
def setUserXY(token:String, x:Int, y:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.setUserXY(token, x, y), HandlerDef(this, "controllers.User", "setUserXY", Seq(classOf[String], classOf[Int], classOf[Int]), "POST", """""", _prefix + """User/setUserXY""")
)
                      
    
}
                          

// @LINE:54
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:29
def chat(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.chat(token), HandlerDef(this, "controllers.Application", "chat", Seq(classOf[String]), "GET", """""", _prefix + """room/chat""")
)
                      

// @LINE:28
def chatRoom(token:Option[String]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.chatRoom(token), HandlerDef(this, "controllers.Application", "chatRoom", Seq(classOf[Option[String]]), "GET", """Chat""", _prefix + """room""")
)
                      

// @LINE:30
def chatRoomJs(token:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.chatRoomJs(token), HandlerDef(this, "controllers.Application", "chatRoomJs", Seq(classOf[String]), "GET", """""", _prefix + """assets/javascripts/chatroom.js""")
)
                      

// @LINE:9
def privacy(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.privacy(), HandlerDef(this, "controllers.Application", "privacy", Seq(), "GET", """""", _prefix + """Privacy""")
)
                      

// @LINE:38
def game(token:String, seq_room:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.game(token, seq_room), HandlerDef(this, "controllers.Application", "game", Seq(classOf[String], classOf[Long]), "GET", """""", _prefix + """game/chat""")
)
                      

// @LINE:39
def gameRoomJS(token:String, seq_room:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.gameRoomJS(token, seq_room), HandlerDef(this, "controllers.Application", "gameRoomJS", Seq(classOf[String], classOf[Long]), "GET", """""", _prefix + """assets/javascripts/gameroom.js""")
)
                      

// @LINE:37
def gameRoom(token:String, seq_room:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.gameRoom(token, seq_room), HandlerDef(this, "controllers.Application", "gameRoom", Seq(classOf[String], classOf[Long]), "GET", """Room""", _prefix + """game""")
)
                      

// @LINE:12
def controller(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.controller(), HandlerDef(this, "controllers.Application", "controller", Seq(), "GET", """""", _prefix + """Controller""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:54
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """ Javascript Route""", _prefix + """javascriptRoutes""")
)
                      
    
}
                          
}
        
    