
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object gameRoom extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Room,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user:User,room:Room):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""

"""),_display_(Seq[Any](/*3.2*/main(Some(user),null,2)/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="col-md-4"><h3>["""),_display_(Seq[Any](/*7.45*/room/*7.49*/.seq)),format.raw/*7.53*/("""] """),_display_(Seq[Any](/*7.56*/room/*7.60*/.title)),format.raw/*7.66*/(""" <button type="button" class="btn btn-danger btn-exit-room btn-sm" id="btn-exit-room">Exit</button></h3></div>
                <div class="col-md-8">"""),_display_(Seq[Any](/*8.40*/if(user.token == room.owner.token)/*8.74*/{_display_(Seq[Any](format.raw/*8.75*/("""
                    """),_display_(Seq[Any](/*9.22*/views/*9.27*/.html.playerProfile(room.owner,null,room.owner.token))),format.raw/*9.80*/("""
                """)))}/*10.18*/else/*10.22*/{_display_(Seq[Any](format.raw/*10.23*/("""
                    """),_display_(Seq[Any](/*11.22*/views/*11.27*/.html.playerProfile(room.owner,user,user.token))),format.raw/*11.74*/("""
                """)))})),format.raw/*12.18*/("""</div>

            </div>
            <div class="panel-body center-block text-center">
                <div id="container"></div>
            </div>
        </div>

    </div>

    <audio src='http://www.matthewlab.com/ham.wav' id="sound_ham">
        Your browser does not support the audio tag.
    </audio>
    <audio src='http://www.matthewlab.com/pika.mp3' id="sound_bgm">
        Your browser does not support the audio tag.
    </audio>

    <form action=""""),_display_(Seq[Any](/*29.20*/routes/*29.26*/.Application.chatRoom(None))),format.raw/*29.53*/("""" class="pull-right" id="form2" style="display: none;">
        <input id="token" name="token" class="input-small" type="text" placeholder="Username" value=""""),_display_(Seq[Any](/*30.103*/user/*30.107*/.token)),format.raw/*30.113*/("""">
        <button class="btn" type="submit">Sign in</button>
    </form>
    <script src=""""),_display_(Seq[Any](/*33.19*/routes/*33.25*/.Assets.at("js/game.js"))),format.raw/*33.49*/("""" type="text/javascript"></script>
    <script type="text/javascript" charset="utf-8" src=""""),_display_(Seq[Any](/*34.58*/routes/*34.64*/.Application.gameRoomJS(user.token,room.seq.get))),format.raw/*34.112*/(""""></script>



""")))})),format.raw/*38.2*/("""
"""))}
    }
    
    def render(user:User,room:Room): play.api.templates.HtmlFormat.Appendable = apply(user,room)
    
    def f:((User,Room) => play.api.templates.HtmlFormat.Appendable) = (user,room) => apply(user,room)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 11:22:16 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/gameRoom.scala.html
                    HASH: b225711e631f9c3693cd5430a7ef0e4249ff74ea
                    MATRIX: 562->1|677->22|714->25|745->48|784->50|974->205|986->209|1011->213|1049->216|1061->220|1088->226|1273->376|1315->410|1353->411|1410->433|1423->438|1497->491|1534->509|1547->513|1586->514|1644->536|1658->541|1727->588|1777->606|2279->1072|2294->1078|2343->1105|2538->1263|2552->1267|2581->1273|2709->1365|2724->1371|2770->1395|2898->1487|2913->1493|2984->1541|3031->1557
                    LINES: 19->1|22->1|24->3|24->3|24->3|28->7|28->7|28->7|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|50->29|50->29|50->29|51->30|51->30|51->30|54->33|54->33|54->33|55->34|55->34|55->34|59->38
                    -- GENERATED --
                */
            