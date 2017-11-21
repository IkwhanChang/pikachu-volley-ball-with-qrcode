
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
object room_players extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[User,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user:User):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.13*/("""
<div class="col-xs-6 col-md-1">
    <div class="thumbnail">
        <img src=""""),_display_(Seq[Any](/*4.20*/user/*4.24*/.pic_url)),format.raw/*4.32*/("""" width="50" height="50" />
        <div class="caption">
            <h5>"""),_display_(Seq[Any](/*6.18*/user/*6.22*/.name)),format.raw/*6.27*/("""</h5>
            <p>"""),_display_(Seq[Any](/*7.17*/if(user.current_location == 0)/*7.47*/{_display_(Seq[Any](format.raw/*7.48*/("""
                <button type="button" id="btn_user_"""),_display_(Seq[Any](/*8.53*/user/*8.57*/.seq)),format.raw/*8.61*/("""" class="btn btn-default btn-xs disabled" data-user-seq=""""),_display_(Seq[Any](/*8.119*/user/*8.123*/.seq)),format.raw/*8.127*/("""">Offline</button>
            """)))})),format.raw/*9.14*/("""
                """),_display_(Seq[Any](/*10.18*/if(user.current_location == 1)/*10.48*/{_display_(Seq[Any](format.raw/*10.49*/("""
                    <button type="button" class="btn btn-warning btn-join btn-xs" data-user-seq=""""),_display_(Seq[Any](/*11.99*/user/*11.103*/.seq)),format.raw/*11.107*/("""">Wait</button>
                """)))})),format.raw/*12.18*/("""
                """),_display_(Seq[Any](/*13.18*/if(user.current_location > 1)/*13.47*/{_display_(Seq[Any](format.raw/*13.48*/("""
                    <button type="button" class="btn btn-info btn-xs disabled" data-user-seq=""""),_display_(Seq[Any](/*14.96*/user/*14.100*/.seq)),format.raw/*14.104*/("""">Playing</button>
                """)))})),format.raw/*15.18*/("""</p>
        </div>
    </div>
</div>

"""))}
    }
    
    def render(user:User): play.api.templates.HtmlFormat.Appendable = apply(user)
    
    def f:((User) => play.api.templates.HtmlFormat.Appendable) = (user) => apply(user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 10:59:49 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/room_players.scala.html
                    HASH: 3b1f2a0dd7fdeaec9c9e9e4b16c70c8481460719
                    MATRIX: 561->1|666->12|781->92|793->96|822->104|932->179|944->183|970->188|1027->210|1065->240|1103->241|1191->294|1203->298|1228->302|1322->360|1335->364|1361->368|1424->400|1478->418|1517->448|1556->449|1691->548|1705->552|1732->556|1797->589|1851->607|1889->636|1928->637|2060->733|2074->737|2101->741|2169->777
                    LINES: 19->1|22->1|25->4|25->4|25->4|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|29->8|29->8|29->8|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15
                    -- GENERATED --
                */
            