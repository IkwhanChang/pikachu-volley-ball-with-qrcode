
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
object chatRoom extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[User,Seq[Room],Seq[User],RequestHeader,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user:User,rooms:Seq[Room],users:Seq[User])(implicit request: RequestHeader):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.78*/("""

"""),_display_(Seq[Any](/*3.2*/main(Some(user),null,1)/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
    <div class="jumbotron">
        <h1>Welcome to NGX VolleyBall</h1>
        <p>our game is world's only remote controlling volley ball game.</p>
    </div>
    <div class="col-md-12">

        <div id="room_main" class=" panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Room List</h3>
            </div>
            <div class="panel-body">
                <table id="tbl_room"  class="table table-bordered datatable">
                    <thead>
                        <th>No</th>
                        <th>Title</th>
                        <th>Owner</th>
                        <th>Score</th>
                        <th>User</th>
                        <th>Action</th>
                    </thead>
                    <tbody id="tbl_room_list">
                        """),_display_(Seq[Any](/*25.26*/views/*25.31*/.html.roomlist(rooms))),format.raw/*25.52*/("""
                    </tbody>
                </table>
            </div>

        </div>
    </div>

    <div class="col-md-12">
        <div id="room_main" class=" panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">User List</h3>
            </div>
            <div class="panel-body">
        <div class="row">
            """),_display_(Seq[Any](/*40.14*/users/*40.19*/.map/*40.23*/{ user =>_display_(Seq[Any](format.raw/*40.32*/("""
                """),_display_(Seq[Any](/*41.18*/views/*41.23*/.html.room_players(user))),format.raw/*41.47*/("""
            """)))})),format.raw/*42.14*/("""
        </div>
                </div></div>

    </div>
    <form action=""""),_display_(Seq[Any](/*47.20*/routes/*47.26*/.Application.gameRoom(user.token,0))),format.raw/*47.61*/("""" class="pull-right" id="form2">
        <input id="token" name="token" value=""""),_display_(Seq[Any](/*48.48*/user/*48.52*/.token)),format.raw/*48.58*/("""" class="input-small" type="hidden" placeholder="Username">
        <input id="seq_room" name="seq_room" value="" class="input-small" type="hidden" placeholder="Username">
    </form>



    <script type="text/javascript" charset="utf-8" src=""""),_display_(Seq[Any](/*54.58*/routes/*54.64*/.Application.chatRoomJs(user.token))),format.raw/*54.99*/(""""></script>

    <script>

        $(document ).ready(function() """),format.raw/*58.39*/("""{"""),format.raw/*58.40*/("""
            $('#btn-join-room' ).click(function(e)"""),format.raw/*59.51*/("""{"""),format.raw/*59.52*/("""
                $('#form2 input[name=seq_room]' ).val($(this ).data('roomSeq'));
                $('#form2' ).submit();
            """),format.raw/*62.13*/("""}"""),format.raw/*62.14*/(""");

            $('.datatable').dataTable();

        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/(""");
    </script>

    <!-- Modal -->
    <div class="modal fade" id="modal_makeroom" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Create New Room</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <span class="input-group-addon">Title</span>
                        <input type="text" id="mkroom_title" class="form-control" placeholder="input room's title">
                    </div>
                    <br />
                    <div class="input-group">
                        <span class="input-group-addon">Max Score</span>
                        <input type="text" id="mkroom_score" class="form-control" placeholder="20, 35, 40...">
                    </div>
                    <br />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="btn-make-room">New</button>
                </div>
            </div>
        </div>
    </div>

""")))})),format.raw/*97.2*/("""
"""))}
    }
    
    def render(user:User,rooms:Seq[Room],users:Seq[User],request:RequestHeader): play.api.templates.HtmlFormat.Appendable = apply(user,rooms,users)(request)
    
    def f:((User,Seq[Room],Seq[User]) => (RequestHeader) => play.api.templates.HtmlFormat.Appendable) = (user,rooms,users) => (request) => apply(user,rooms,users)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jun 02 13:15:36 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/chatRoom.scala.html
                    HASH: 1080622d9a955e879c0666cb5ef262aedb8211f5
                    MATRIX: 591->1|761->77|798->80|829->103|868->105|1740->941|1754->946|1797->967|2211->1345|2225->1350|2238->1354|2285->1363|2339->1381|2353->1386|2399->1410|2445->1424|2557->1500|2572->1506|2629->1541|2745->1621|2758->1625|2786->1631|3066->1875|3081->1881|3138->1916|3231->1981|3260->1982|3339->2033|3368->2034|3529->2167|3558->2168|3639->2222|3668->2223|5146->3670
                    LINES: 19->1|22->1|24->3|24->3|24->3|46->25|46->25|46->25|61->40|61->40|61->40|61->40|62->41|62->41|62->41|63->42|68->47|68->47|68->47|69->48|69->48|69->48|75->54|75->54|75->54|79->58|79->58|80->59|80->59|83->62|83->62|87->66|87->66|118->97
                    -- GENERATED --
                */
            