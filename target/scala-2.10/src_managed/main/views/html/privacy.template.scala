
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
object privacy extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Flash,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit flash: Flash):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""

<h2>개인정보취급방침</h2>
<h3>NGX FBVOL 에서 수집하는 정보</h3>
<p>사용자가 동의한 정보 : 사용자 기본 공개정보, 친구 목록</p>
<h3>NGX FBVOL 에서 수집한 정보의 활용</h3>
<p>원활한 게임 진행을 위해 사용됩니다.</p>
<h3>개인정보 담당자</h3>
<p>Matthew, Chang ( matthew.chang@me.com )</p>"""))}
    }
    
    def render(flash:Flash): play.api.templates.HtmlFormat.Appendable = apply()(flash)
    
    def f:(() => (Flash) => play.api.templates.HtmlFormat.Appendable) = () => (flash) => apply()(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jun 02 14:31:15 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/privacy.scala.html
                    HASH: bf6e400c637241237c5fdf37c2d5cce4ab650295
                    MATRIX: 557->1|676->26
                    LINES: 19->1|22->1
                    -- GENERATED --
                */
            