
package views.js

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.js._
/**/
object chatRoom extends BaseScalaTemplate[play.api.templates.JavaScriptFormat.Appendable,Format[play.api.templates.JavaScriptFormat.Appendable]](play.api.templates.JavaScriptFormat) with play.api.templates.Template2[User,RequestHeader,play.api.templates.JavaScriptFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: User)(implicit r: RequestHeader):play.api.templates.JavaScriptFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""

$(document ).ready(function() """),format.raw/*3.31*/("""{"""),format.raw/*3.32*/("""

    var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
    var chatSocket = new WS(""""),_display_(Seq[Any](/*6.31*/routes/*6.37*/.Application.chat(user.token).webSocketURL())),format.raw/*6.81*/("""")
    //chatSocket.replace("ws:","wss:");

    $.sendMessage = function() """),format.raw/*9.32*/("""{"""),format.raw/*9.33*/("""
        chatSocket.send(JSON.stringify(
            """),format.raw/*11.13*/("""{"""),format.raw/*11.14*/("""text: $("#talk").val()"""),format.raw/*11.36*/("""}"""),format.raw/*11.37*/("""
        ))
        $("#talk").val('')
    """),format.raw/*14.5*/("""}"""),format.raw/*14.6*/("""

    $.receiveEvent = function(event) """),format.raw/*16.38*/("""{"""),format.raw/*16.39*/("""
        var data = JSON.parse(event.data)
        console.log(data)
        // Handle errors
        if(data.Action == "makeRoom" && """"),_display_(Seq[Any](/*20.43*/user/*20.47*/.token)),format.raw/*20.53*/("""" != data.owner_id)"""),format.raw/*20.72*/("""{"""),format.raw/*20.73*/("""
            var table = $("#tbl_room").DataTable();

            var rowNode = table.row.add([data.seq,
                data.title,
                data.owner,
                data.time,
                "",
                '<button type="button" class="btn btn-primary btn-join-room  btn-sm" id="btn-join-room" data-room-title="'+data.title+'" data-room-no="'+data.seq+'" data-room-seq="'+data.seq+'">Join</button>'
            ]).draw(function() """),format.raw/*29.32*/("""{"""),format.raw/*29.33*/("""
                $(".btn-join-room").click(function() """),format.raw/*30.54*/("""{"""),format.raw/*30.55*/("""
                    $("#form2 input[name=seq_room]").val($(this).data("roomSeq"));
                    $("#form2").submit();
                """),format.raw/*33.17*/("""}"""),format.raw/*33.18*/(""");
                $(this).addClass("room_"+data.seq);
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/(""").nodes()
                .to$()
                .addClass( "room_"+data.seq );

            $(rowNode).addClass("room_"+data.seq);

            $(".btn-join-room").click(function() """),format.raw/*41.50*/("""{"""),format.raw/*41.51*/("""
                $("#form2 input[name=seq_room]").val($(this).data("roomSeq"));
                $("#form2").submit();
            """),format.raw/*44.13*/("""}"""),format.raw/*44.14*/(""");
        """),format.raw/*45.9*/("""}"""),format.raw/*45.10*/("""

        if(data.Action == "quitRoom")"""),format.raw/*47.38*/("""{"""),format.raw/*47.39*/("""
            var roomClass = ".room_"+data.seq;
            $(roomClass).hide();
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/("""

        if(data.Action == "join")"""),format.raw/*52.34*/("""{"""),format.raw/*52.35*/("""
            $.setUserStatus(data.seq,"join");
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""

        if(data.Action == "quit")"""),format.raw/*56.34*/("""{"""),format.raw/*56.35*/("""
            $.setUserStatus(data.seq,"quit");
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/("""

        if(data.Action == "joinRoom")"""),format.raw/*60.38*/("""{"""),format.raw/*60.39*/("""
            $.setUserStatus(data.seq,"joinRoom");
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/("""

    """),format.raw/*64.5*/("""}"""),format.raw/*64.6*/("""

    chatSocket.onmessage = function(e) """),format.raw/*66.40*/("""{"""),format.raw/*66.41*/("""
        $.receiveEvent(e);
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/("""
    $.setUserStatus = function(seq,status) """),format.raw/*69.44*/("""{"""),format.raw/*69.45*/("""
        var btnId = "#btn_user_"+seq;
        if(status == "join")"""),format.raw/*71.29*/("""{"""),format.raw/*71.30*/("""
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("btn-warning").val("Waiting");
        """),format.raw/*73.9*/("""}"""),format.raw/*73.10*/("""else if(status == "joinRoom")"""),format.raw/*73.39*/("""{"""),format.raw/*73.40*/("""
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("btn-info").val("Playing");
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""else if(status == "create")"""),format.raw/*75.37*/("""{"""),format.raw/*75.38*/("""
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("btn-info").val("Playing");
        """),format.raw/*77.9*/("""}"""),format.raw/*77.10*/("""else if(status == "quit")"""),format.raw/*77.35*/("""{"""),format.raw/*77.36*/("""
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("disabled").addClass("btn-default").val("Offline");
        """),format.raw/*79.9*/("""}"""),format.raw/*79.10*/("""
    """),format.raw/*80.5*/("""}"""),format.raw/*80.6*/("""

    $("#btn-make-room").click(function() """),format.raw/*82.42*/("""{"""),format.raw/*82.43*/("""
        $.ajax(
                jsRoutes.controllers.Room.addRoom(
                    $("#mkroom_title").val(),
                    $("#mkroom_score").val(),
                    """"),_display_(Seq[Any](/*87.23*/user/*87.27*/.token)),format.raw/*87.33*/(""""
                )
            ).done(function(data)"""),format.raw/*89.34*/("""{"""),format.raw/*89.35*/("""
                console.log(data.seq);
                //location.href="/game?token="""),_display_(Seq[Any](/*91.47*/user/*91.51*/.token)),format.raw/*91.57*/("""&seq_room="+data.seq
                $("#form2 input[name=seq_room]").val(data.seq);
                $("#form2").submit();

            """),format.raw/*95.13*/("""}"""),format.raw/*95.14*/(""" ).fail(function(e)"""),format.raw/*95.33*/("""{"""),format.raw/*95.34*/("""
                console.log(e);
            """),format.raw/*97.13*/("""}"""),format.raw/*97.14*/(""");
    """),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""");

    $(".btn-join-room").click(function() """),format.raw/*100.42*/("""{"""),format.raw/*100.43*/("""
        $("#form2 input[name=seq_room]").val($(this).data("roomSeq"));
        $("#form2").submit();
    """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""");
"""),format.raw/*104.1*/("""}"""),format.raw/*104.2*/(""");"""))}
    }
    
    def render(user:User,r:RequestHeader): play.api.templates.JavaScriptFormat.Appendable = apply(user)(r)
    
    def f:((User) => (RequestHeader) => play.api.templates.JavaScriptFormat.Appendable) = (user) => (r) => apply(user)(r)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 10:56:33 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/chatRoom.scala.js
                    HASH: a3482f5f5a66e3045a61dec192e8ce2383fa4e2a
                    MATRIX: 591->1|730->40|789->72|817->73|947->168|961->174|1026->218|1128->293|1156->294|1237->347|1266->348|1316->370|1345->371|1415->414|1443->415|1510->454|1539->455|1711->591|1724->595|1752->601|1799->620|1828->621|2304->1069|2333->1070|2415->1124|2444->1125|2614->1267|2643->1268|2738->1335|2767->1336|2977->1518|3006->1519|3164->1649|3193->1650|3231->1661|3260->1662|3327->1701|3356->1702|3472->1791|3501->1792|3564->1827|3593->1828|3675->1883|3704->1884|3767->1919|3796->1920|3878->1975|3907->1976|3974->2015|4003->2016|4089->2075|4118->2076|4151->2082|4179->2083|4248->2124|4277->2125|4336->2157|4364->2158|4436->2202|4465->2203|4560->2270|4589->2271|4788->2443|4817->2444|4874->2473|4903->2474|5099->2643|5128->2644|5183->2671|5212->2672|5408->2841|5437->2842|5490->2867|5519->2868|5739->3061|5768->3062|5800->3067|5828->3068|5899->3111|5928->3112|6146->3294|6159->3298|6187->3304|6268->3357|6297->3358|6419->3444|6432->3448|6460->3454|6624->3590|6653->3591|6700->3610|6729->3611|6802->3656|6831->3657|6865->3664|6893->3665|6967->3710|6997->3711|7131->3817|7160->3818|7191->3821|7220->3822
                    LINES: 19->1|22->1|24->3|24->3|27->6|27->6|27->6|30->9|30->9|32->11|32->11|32->11|32->11|35->14|35->14|37->16|37->16|41->20|41->20|41->20|41->20|41->20|50->29|50->29|51->30|51->30|54->33|54->33|56->35|56->35|62->41|62->41|65->44|65->44|66->45|66->45|68->47|68->47|71->50|71->50|73->52|73->52|75->54|75->54|77->56|77->56|79->58|79->58|81->60|81->60|83->62|83->62|85->64|85->64|87->66|87->66|89->68|89->68|90->69|90->69|92->71|92->71|94->73|94->73|94->73|94->73|96->75|96->75|96->75|96->75|98->77|98->77|98->77|98->77|100->79|100->79|101->80|101->80|103->82|103->82|108->87|108->87|108->87|110->89|110->89|112->91|112->91|112->91|116->95|116->95|116->95|116->95|118->97|118->97|119->98|119->98|121->100|121->100|124->103|124->103|125->104|125->104
                    -- GENERATED --
                */
            