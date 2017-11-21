
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
object roomlist extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[Room],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(rooms:Seq[Room]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""
"""),_display_(Seq[Any](/*2.2*/rooms/*2.7*/.zipWithIndex.map/*2.24*/{ case(room,no) =>_display_(Seq[Any](format.raw/*2.42*/("""
  <tr id="roomlist_"""),_display_(Seq[Any](/*3.21*/room/*3.25*/.seq)),format.raw/*3.29*/("""">
      <td>"""),_display_(Seq[Any](/*4.12*/room/*4.16*/.seq)),format.raw/*4.20*/("""</td>
      <td>"""),_display_(Seq[Any](/*5.12*/room/*5.16*/.title)),format.raw/*5.22*/("""</td>

      <td>"""),_display_(Seq[Any](/*7.12*/room/*7.16*/.owner.name)),format.raw/*7.27*/("""</td>
      <td>"""),_display_(Seq[Any](/*8.12*/room/*8.16*/.time)),format.raw/*8.21*/("""</td>
      <td>"""),_display_(Seq[Any](/*9.12*/room/*9.16*/.game_status/*9.28*/ match/*9.34*/ {/*10.11*/case 1 =>/*10.20*/ {_display_(Seq[Any](format.raw/*10.22*/("""<span class="label label-default">wait</span>""")))}/*11.11*/case 2 =>/*11.20*/ {_display_(Seq[Any](format.raw/*11.22*/("""<span class="label label-info">playing</span>""")))}/*12.11*/case _ =>/*12.20*/ {_display_(Seq[Any](format.raw/*12.22*/("""ERROR""")))}})),format.raw/*13.8*/("""
      </td>
        <td><button type="button" class="btn btn-primary btn-join-room  btn-sm" id="btn-join-room" data-room-title=""""),_display_(Seq[Any](/*15.118*/room/*15.122*/.title)),format.raw/*15.128*/("""" data-room-no=""""),_display_(Seq[Any](/*15.145*/{no+1})),format.raw/*15.151*/("""" data-room-seq=""""),_display_(Seq[Any](/*15.169*/room/*15.173*/.seq)),format.raw/*15.177*/("""">Join</button></td>
  </tr>
""")))})),format.raw/*17.2*/("""

"""))}
    }
    
    def render(rooms:Seq[Room]): play.api.templates.HtmlFormat.Appendable = apply(rooms)
    
    def f:((Seq[Room]) => play.api.templates.HtmlFormat.Appendable) = (rooms) => apply(rooms)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 10:00:23 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/roomlist.scala.html
                    HASH: b2168676887529dcfd4d15fe40d2b1ddc4a26c48
                    MATRIX: 562->1|673->18|709->20|721->25|746->42|801->60|857->81|869->85|894->89|943->103|955->107|980->111|1032->128|1044->132|1071->138|1124->156|1136->160|1168->171|1220->188|1232->192|1258->197|1310->214|1322->218|1342->230|1356->236|1367->249|1385->258|1425->260|1490->317|1508->326|1548->328|1613->385|1631->394|1671->396|1709->410|1876->540|1890->544|1919->550|1973->567|2002->573|2057->591|2071->595|2098->599|2159->629
                    LINES: 19->1|22->1|23->2|23->2|23->2|23->2|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|30->9|30->10|30->10|30->10|30->11|30->11|30->11|30->12|30->12|30->12|30->13|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|34->17
                    -- GENERATED --
                */
            