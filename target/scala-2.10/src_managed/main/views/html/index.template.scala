
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Flash,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash: Flash):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""

"""),_display_(Seq[Any](/*3.2*/main(null,null,0)/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""

    """),_display_(Seq[Any](/*5.6*/flash/*5.11*/.get("error").map/*5.28*/ { errorMessage =>_display_(Seq[Any](format.raw/*5.46*/("""

        <div class="alert-message error">
            <p>
                <strong>Oops!</strong> """),_display_(Seq[Any](/*9.41*/errorMessage)),format.raw/*9.53*/("""
            </p>
        </div>

    """)))})),format.raw/*13.6*/("""

    <div class="alert-message block-message info">
        <p>
            <strong>This is the NGX Facebook Remote Volley Ball application!</strong>
            To start, sign in your facebook account using the top right form.
        </p>
    </div>

""")))})))}
    }
    
    def render(flash:Flash): play.api.templates.HtmlFormat.Appendable = apply()(flash)
    
    def f:(() => (Flash) => play.api.templates.HtmlFormat.Appendable) = () => (flash) => apply()(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 16:50:20 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/index.scala.html
                    HASH: 3359557f08c14663736df1f346df12f7c0e67c37
                    MATRIX: 555->1|674->26|711->29|736->46|775->48|816->55|829->60|854->77|909->95|1044->195|1077->207|1147->246
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|26->5|30->9|30->9|34->13
                    -- GENERATED --
                */
            