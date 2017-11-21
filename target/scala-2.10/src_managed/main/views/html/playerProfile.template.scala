
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
object playerProfile extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[User,User,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user1:User, user2:User=null, token:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""
<ul class="list-inline">
    <li><img src=""""),_display_(Seq[Any](/*3.20*/user1/*3.25*/.pic_url)),format.raw/*3.33*/("""" width="25" height="25" /></li>
    <li><h5>"""),_display_(Seq[Any](/*4.14*/user1/*4.19*/.name)),format.raw/*4.24*/("""</h5></li>
    <li>vs</li>

"""),_display_(Seq[Any](/*7.2*/if(user2 != null)/*7.19*/ {_display_(Seq[Any](format.raw/*7.21*/("""
    <li><img src=""""),_display_(Seq[Any](/*8.20*/user2/*8.25*/.pic_url)),format.raw/*8.33*/("""" width="25" height="25" /></li>
    <li><h5>"""),_display_(Seq[Any](/*9.14*/user2/*9.19*/.name)),format.raw/*9.24*/("""</h5></li>
""")))}/*10.2*/else/*10.6*/{_display_(Seq[Any](format.raw/*10.7*/("""
    <li id="enemy_1">No Player</li>
    <li><img width="25" height="25"  id="enemy_2" style="display: none;" /></li>
    <li><h5 id="enemy_3"  style="display: none;"></h5></li>
""")))})),format.raw/*14.2*/("""
    """),_display_(Seq[Any](/*15.6*/if(user1.token == token)/*15.30*/{_display_(Seq[Any](format.raw/*15.31*/("""
        <li><button type="button" class="btn btn-info btn-xs btn-play disabled">Play</button></li>
    """)))}/*17.6*/else/*17.10*/{_display_(Seq[Any](format.raw/*17.11*/("""
        <li><button type="button" class="btn btn-warning btn-xs btn-ready">Ready</button></li>
    """)))})),format.raw/*19.6*/("""
"""))}
    }
    
    def render(user1:User,user2:User,token:String): play.api.templates.HtmlFormat.Appendable = apply(user1,user2,token)
    
    def f:((User,User,String) => play.api.templates.HtmlFormat.Appendable) = (user1,user2,token) => apply(user1,user2,token)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 16:52:35 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/playerProfile.scala.html
                    HASH: 9d27194d1ec8f634330451283a716d28a3f98b8a
                    MATRIX: 574->1|711->44|791->89|804->94|833->102|914->148|927->153|953->158|1016->187|1041->204|1080->206|1135->226|1148->231|1177->239|1258->285|1271->290|1297->295|1327->307|1339->311|1377->312|1587->491|1628->497|1661->521|1700->522|1823->627|1836->631|1875->632|2007->733
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|35->14|36->15|36->15|36->15|38->17|38->17|38->17|40->19
                    -- GENERATED --
                */
            