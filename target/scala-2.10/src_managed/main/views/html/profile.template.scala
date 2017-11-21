
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
object profile extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Option[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user:Option[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.21*/("""
<li><img src=""""),_display_(Seq[Any](/*2.16*/user/*2.20*/.get.pic_url)),format.raw/*2.32*/(""""  width="50" height="50" /></li>
<li><a href="#"><strong>"""),_display_(Seq[Any](/*3.26*/user/*3.30*/.get.name)),format.raw/*3.39*/("""</strong></a></li>

"""))}
    }
    
    def render(user:Option[User]): play.api.templates.HtmlFormat.Appendable = apply(user)
    
    def f:((Option[User]) => play.api.templates.HtmlFormat.Appendable) = (user) => apply(user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon May 26 22:40:42 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/profile.scala.html
                    HASH: d35acb6cb721e6cd8003e9a997c9e85eeb6e7c07
                    MATRIX: 564->1|677->20|728->36|740->40|773->52|867->111|879->115|909->124
                    LINES: 19->1|22->1|23->2|23->2|23->2|24->3|24->3|24->3
                    -- GENERATED --
                */
            