
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
object gameRoom extends BaseScalaTemplate[play.api.templates.JavaScriptFormat.Appendable,Format[play.api.templates.JavaScriptFormat.Appendable]](play.api.templates.JavaScriptFormat) with play.api.templates.Template3[User,Room,RequestHeader,play.api.templates.JavaScriptFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: User, room:Room)(implicit r: RequestHeader):play.api.templates.JavaScriptFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

$(document ).ready(function() """),format.raw/*3.31*/("""{"""),format.raw/*3.32*/("""

    var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
    var gameSocket = new WS(""""),_display_(Seq[Any](/*6.31*/routes/*6.37*/.Application.game(user.token,room.seq.getOrElse(0)).webSocketURL())),format.raw/*6.103*/("""");
    //chatSocket.replace("ws:","wss:");

    $.sendMessage = function() """),format.raw/*9.32*/("""{"""),format.raw/*9.33*/("""
        gameSocket.send(JSON.stringify(
            """),format.raw/*11.13*/("""{"""),format.raw/*11.14*/("""text: "haha""""),format.raw/*11.26*/("""}"""),format.raw/*11.27*/("""
        ))
        //$("#talk").val('')
    """),format.raw/*14.5*/("""}"""),format.raw/*14.6*/("""

    $.receiveEvent = function(event) """),format.raw/*16.38*/("""{"""),format.raw/*16.39*/("""
        var data = JSON.parse(event.data)
        console.log(data);

        if(data.action == "join")"""),format.raw/*20.34*/("""{"""),format.raw/*20.35*/("""
            if(""""),_display_(Seq[Any](/*21.18*/room/*21.22*/.owner.token)),format.raw/*21.34*/("""" == data.token)   $.addUser(0,data);
            else"""),format.raw/*22.17*/("""{"""),format.raw/*22.18*/("""
                $.addUser(1,data);
                $.addUserProfile(data);
            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/("""

            //$.addUser(data);

        """),format.raw/*29.9*/("""}"""),format.raw/*29.10*/("""

        if(data.action == "addOwner") """),format.raw/*31.39*/("""{"""),format.raw/*31.40*/("""
            if(""""),_display_(Seq[Any](/*32.18*/room/*32.22*/.owner.token)),format.raw/*32.34*/("""" != """"),_display_(Seq[Any](/*32.41*/user/*32.45*/.token)),format.raw/*32.51*/("""")
            $.addOwner(""""),_display_(Seq[Any](/*33.26*/room/*33.30*/.owner.token)),format.raw/*33.42*/("""",""""),_display_(Seq[Any](/*33.46*/room/*33.50*/.owner.name)),format.raw/*33.61*/("""",""""),_display_(Seq[Any](/*33.65*/room/*33.69*/.owner.pic_url)),format.raw/*33.83*/("""");
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""

        if(data.action == "move")"""),format.raw/*36.34*/("""{"""),format.raw/*36.35*/("""
            if(""""),_display_(Seq[Any](/*37.18*/room/*37.22*/.owner.token)),format.raw/*37.34*/("""" == data.token)   $.setUserXY(0,data.token, data.x, data.y);
            else                                    $.setUserXY(1,data.token, data.x, data.y);

        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/("""

        if(data.action == "jump")"""),format.raw/*42.34*/("""{"""),format.raw/*42.35*/("""

            if(""""),_display_(Seq[Any](/*44.18*/room/*44.22*/.owner.token)),format.raw/*44.34*/("""" == data.token)   $.jumpAction(0);
            else                                    $.jumpAction(1);

        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""


        if(data.action == "shoot")"""),format.raw/*50.35*/("""{"""),format.raw/*50.36*/("""
            if(""""),_display_(Seq[Any](/*51.18*/room/*51.22*/.owner.token)),format.raw/*51.34*/("""" == data.token)   $.shooting(0);
            else                                    $.shooting(1);

        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""

        if(data.action == "ready")"""),format.raw/*56.35*/("""{"""),format.raw/*56.36*/("""
            if(""""),_display_(Seq[Any](/*57.18*/room/*57.22*/.owner.token)),format.raw/*57.34*/("""" == """"),_display_(Seq[Any](/*57.41*/user/*57.45*/.token)),format.raw/*57.51*/("""")"""),format.raw/*57.53*/("""{"""),format.raw/*57.54*/("""
                $(".btn-play").removeClass("disabled");
            """),format.raw/*59.13*/("""}"""),format.raw/*59.14*/("""

        """),format.raw/*61.9*/("""}"""),format.raw/*61.10*/("""

        if(data.action == "quit")"""),format.raw/*63.34*/("""{"""),format.raw/*63.35*/("""
            alert(data.name+" is quit!\nGame will exit");
            //alert($("#form2[id=token]")).val();
            $("#form2").submit();
        """),format.raw/*67.9*/("""}"""),format.raw/*67.10*/("""

        if(data.action == "play")"""),format.raw/*69.34*/("""{"""),format.raw/*69.35*/("""
            ballMode = 'reset';
        """),format.raw/*71.9*/("""}"""),format.raw/*71.10*/("""

        /*
        // Handle errors
        if(data.error) """),format.raw/*75.24*/("""{"""),format.raw/*75.25*/("""
            chatSocket.close()
            $("#onError span").text(data.error)
            $("#onError").show()
            return
        """),format.raw/*80.9*/("""}"""),format.raw/*80.10*/(""" else """),format.raw/*80.16*/("""{"""),format.raw/*80.17*/("""
            $("#onChat").show()
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/("""

        // Create the message element
        var el = $('<div class="message"><span></span><p></p></div>')
        $("span", el).text(data.user)
        $("p", el).text(data.message)
        $(el).addClass(data.kind)
        if(data.user == '"""),_display_(Seq[Any](/*89.27*/user/*89.31*/.name)),format.raw/*89.36*/("""') $(el).addClass('me')
        $('#messages').append(el)

        // Update the members list
        $("#members").html('')
        $(data.members).each(function() """),format.raw/*94.41*/("""{"""),format.raw/*94.42*/("""
            var li = document.createElement('li');
            li.textContent = this;
            $("#members").append(li);
        """),format.raw/*98.9*/("""}"""),format.raw/*98.10*/(""")
        */
    """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/("""

    $.addUserProfile = function(data) """),format.raw/*102.39*/("""{"""),format.raw/*102.40*/("""
        $("#enemy_1").hide();
        $("#enemy_2").attr("src",data.pic_url);
        $("#enemy_3").html(data.name);
        $("#enemy_2").show();
        $("#enemy_3").show();
    """),format.raw/*108.5*/("""}"""),format.raw/*108.6*/("""

    gameSocket.onmessage = function(e) """),format.raw/*110.40*/("""{"""),format.raw/*110.41*/("""
        $.receiveEvent(e);
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""

    $("#btn-exit-room").click(function() """),format.raw/*114.42*/("""{"""),format.raw/*114.43*/("""
        //$.sendMessage();
        if(confirm("Do you really want to exit game?"))"""),format.raw/*116.56*/("""{"""),format.raw/*116.57*/("""
            gameSocket.send(JSON.stringify(
                """),format.raw/*118.17*/("""{"""),format.raw/*118.18*/("""
                    seq_room: """),_display_(Seq[Any](/*119.32*/room/*119.36*/.seq)),format.raw/*119.40*/("""
                """),format.raw/*120.17*/("""}"""),format.raw/*120.18*/("""
            ))
        """),format.raw/*122.9*/("""}"""),format.raw/*122.10*/("""

    """),format.raw/*124.5*/("""}"""),format.raw/*124.6*/(""");

    $(".btn-play").click(function() """),format.raw/*126.37*/("""{"""),format.raw/*126.38*/("""
        gameSocket.send(JSON.stringify(
            """),format.raw/*128.13*/("""{"""),format.raw/*128.14*/("""
                seq_play_room: """),_display_(Seq[Any](/*129.33*/room/*129.37*/.seq)),format.raw/*129.41*/(""",
                play:1
            """),format.raw/*131.13*/("""}"""),format.raw/*131.14*/("""
        ))
        /*if(ballMode == 'ready')  ballMode = 'reset';
        else"""),format.raw/*134.13*/("""{"""),format.raw/*134.14*/("""
            $.jumpAction(1);
            $.jumpAction(0);
            //$.shooting(0);
            //$.shooting(1);
        """),format.raw/*139.9*/("""}"""),format.raw/*139.10*/("""*/
    """),format.raw/*140.5*/("""}"""),format.raw/*140.6*/(""");

    $(".btn-ready").click(function() """),format.raw/*142.38*/("""{"""),format.raw/*142.39*/("""
        gameSocket.send(JSON.stringify(
            """),format.raw/*144.13*/("""{"""),format.raw/*144.14*/("""
                seq_ready_room: """),_display_(Seq[Any](/*145.34*/room/*145.38*/.seq)),format.raw/*145.42*/(""",
                ready:1
            """),format.raw/*147.13*/("""}"""),format.raw/*147.14*/("""
        ))
    """),format.raw/*149.5*/("""}"""),format.raw/*149.6*/(""");

    $.setOwnerButton = function () """),format.raw/*151.36*/("""{"""),format.raw/*151.37*/("""
        if(""""),_display_(Seq[Any](/*152.14*/room/*152.18*/.owner.token)),format.raw/*152.30*/("""" == """"),_display_(Seq[Any](/*152.37*/user/*152.41*/.token)),format.raw/*152.47*/("""")"""),format.raw/*152.49*/("""{"""),format.raw/*152.50*/("""
            $(".btn-play").addClass("disabled");
        """),format.raw/*154.9*/("""}"""),format.raw/*154.10*/("""
    """),format.raw/*155.5*/("""}"""),format.raw/*155.6*/("""

    $.writeResult = function(winner,users) """),format.raw/*157.44*/("""{"""),format.raw/*157.45*/("""
        if(winner == 0 && """"),_display_(Seq[Any](/*158.29*/room/*158.33*/.owner.token)),format.raw/*158.45*/("""" == """"),_display_(Seq[Any](/*158.52*/user/*158.56*/.token)),format.raw/*158.62*/("""") """),format.raw/*158.65*/("""{"""),format.raw/*158.66*/(""" // 내가 방장이고 방장이이겼을때
            /* make the API call */
            FB.api(
                "/me/feed",
                "POST",
                """),format.raw/*163.17*/("""{"""),format.raw/*163.18*/("""
                    "object": """),format.raw/*164.31*/("""{"""),format.raw/*164.32*/("""
                        "message": users[0].name+"님이 "+users[1].name+"님과의 NGX 게임에서 승리하였습니다. 축하해 주세요!",
                        "link" : "https://apps.facebook.com/ngx_fbvol/"
                    """),format.raw/*167.21*/("""}"""),format.raw/*167.22*/("""
                """),format.raw/*168.17*/("""}"""),format.raw/*168.18*/(""",
                function (response) """),format.raw/*169.37*/("""{"""),format.raw/*169.38*/("""
                    console.log(response);
                    if (response && !response.error) """),format.raw/*171.54*/("""{"""),format.raw/*171.55*/("""
                        /* handle the result */
                    """),format.raw/*173.21*/("""}"""),format.raw/*173.22*/("""
                """),format.raw/*174.17*/("""}"""),format.raw/*174.18*/("""
            );
        """),format.raw/*176.9*/("""}"""),format.raw/*176.10*/("""else if(winner == 1 && """"),_display_(Seq[Any](/*176.35*/room/*176.39*/.owner.token)),format.raw/*176.51*/("""" == """"),_display_(Seq[Any](/*176.58*/user/*176.62*/.token)),format.raw/*176.68*/("""")"""),format.raw/*176.70*/("""{"""),format.raw/*176.71*/("""
            /* make the API call */
            FB.api(
                "/me/feed",
                "POST",
                """),format.raw/*181.17*/("""{"""),format.raw/*181.18*/("""
                    "object": """),format.raw/*182.31*/("""{"""),format.raw/*182.32*/("""
                        "message": users[0].name+"님이 "+users[1].name+"님과의 NGX 게임에서 졌습니다. 놀려 주세요!",
                        "link" : "https://apps.facebook.com/ngx_fbvol/"
                    """),format.raw/*185.21*/("""}"""),format.raw/*185.22*/("""
                """),format.raw/*186.17*/("""}"""),format.raw/*186.18*/(""",
                function (response) """),format.raw/*187.37*/("""{"""),format.raw/*187.38*/("""
                    console.log(response);
                    if (response && !response.error) """),format.raw/*189.54*/("""{"""),format.raw/*189.55*/("""
                        /* handle the result */
                    """),format.raw/*191.21*/("""}"""),format.raw/*191.22*/("""
                """),format.raw/*192.17*/("""}"""),format.raw/*192.18*/("""
            );
        """),format.raw/*194.9*/("""}"""),format.raw/*194.10*/("""else if(winner == 0 && """"),_display_(Seq[Any](/*194.35*/room/*194.39*/.owner.token)),format.raw/*194.51*/("""" != """"),_display_(Seq[Any](/*194.58*/user/*194.62*/.token)),format.raw/*194.68*/("""")"""),format.raw/*194.70*/("""{"""),format.raw/*194.71*/("""
            /* make the API call */
            FB.api(
                "/me/feed",
                "POST",
                """),format.raw/*199.17*/("""{"""),format.raw/*199.18*/("""
                    "object": """),format.raw/*200.31*/("""{"""),format.raw/*200.32*/("""
                        "message": users[1].name+"님이 "+users[0].name+"님과의 NGX 게임에서 졌습니다. 놀려 주세요!",
                        "link" : "https://apps.facebook.com/ngx_fbvol/"
                    """),format.raw/*203.21*/("""}"""),format.raw/*203.22*/("""
                """),format.raw/*204.17*/("""}"""),format.raw/*204.18*/(""",
                function (response) """),format.raw/*205.37*/("""{"""),format.raw/*205.38*/("""
                    console.log(response);
                    if (response && !response.error) """),format.raw/*207.54*/("""{"""),format.raw/*207.55*/("""
                        /* handle the result */
                    """),format.raw/*209.21*/("""}"""),format.raw/*209.22*/("""
                """),format.raw/*210.17*/("""}"""),format.raw/*210.18*/("""
            );
        """),format.raw/*212.9*/("""}"""),format.raw/*212.10*/("""else if(winner == 1 && """"),_display_(Seq[Any](/*212.35*/room/*212.39*/.owner.token)),format.raw/*212.51*/("""" != """"),_display_(Seq[Any](/*212.58*/user/*212.62*/.token)),format.raw/*212.68*/("""")"""),format.raw/*212.70*/("""{"""),format.raw/*212.71*/("""
            /* make the API call */
            FB.api(
                "/me/feed",
                "POST",
                """),format.raw/*217.17*/("""{"""),format.raw/*217.18*/("""
                    "object": """),format.raw/*218.31*/("""{"""),format.raw/*218.32*/("""
                        "message": users[0].name+"님이 "+users[1].name+"님과의 NGX 게임에서 승리하였습니다. 축하해 주세요!",
                        "link" : "https://apps.facebook.com/ngx_fbvol/"
                    """),format.raw/*221.21*/("""}"""),format.raw/*221.22*/("""
                """),format.raw/*222.17*/("""}"""),format.raw/*222.18*/(""",
                function (response) """),format.raw/*223.37*/("""{"""),format.raw/*223.38*/("""
                    console.log(response);
                    if (response && !response.error) """),format.raw/*225.54*/("""{"""),format.raw/*225.55*/("""
                        /* handle the result */
                    """),format.raw/*227.21*/("""}"""),format.raw/*227.22*/("""
                """),format.raw/*228.17*/("""}"""),format.raw/*228.18*/("""
            );
        """),format.raw/*230.9*/("""}"""),format.raw/*230.10*/("""
    """),format.raw/*231.5*/("""}"""),format.raw/*231.6*/("""

    $.settingScore("""),_display_(Seq[Any](/*233.21*/room/*233.25*/.time)),format.raw/*233.30*/(""");

"""),format.raw/*235.1*/("""}"""),format.raw/*235.2*/(""");"""))}
    }
    
    def render(user:User,room:Room,r:RequestHeader): play.api.templates.JavaScriptFormat.Appendable = apply(user,room)(r)
    
    def f:((User,Room) => (RequestHeader) => play.api.templates.JavaScriptFormat.Appendable) = (user,room) => (r) => apply(user,room)(r)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 16:56:24 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/gameRoom.scala.js
                    HASH: b6811923e5f896d6471425d28c7f91e8165b731f
                    MATRIX: 596->1|746->51|805->83|833->84|963->179|977->185|1065->251|1168->327|1196->328|1277->381|1306->382|1346->394|1375->395|1447->440|1475->441|1542->480|1571->481|1703->585|1732->586|1786->604|1799->608|1833->620|1915->674|1944->675|2060->763|2089->764|2158->806|2187->807|2255->847|2284->848|2338->866|2351->870|2385->882|2428->889|2441->893|2469->899|2533->927|2546->931|2580->943|2620->947|2633->951|2666->962|2706->966|2719->970|2755->984|2794->996|2823->997|2886->1032|2915->1033|2969->1051|2982->1055|3016->1067|3209->1233|3238->1234|3301->1269|3330->1270|3385->1289|3398->1293|3432->1305|3573->1419|3602->1420|3667->1457|3696->1458|3750->1476|3763->1480|3797->1492|3934->1602|3963->1603|4027->1639|4056->1640|4110->1658|4123->1662|4157->1674|4200->1681|4213->1685|4241->1691|4271->1693|4300->1694|4397->1763|4426->1764|4463->1774|4492->1775|4555->1810|4584->1811|4762->1962|4791->1963|4854->1998|4883->1999|4951->2040|4980->2041|5069->2102|5098->2103|5265->2243|5294->2244|5328->2250|5357->2251|5425->2292|5454->2293|5736->2539|5749->2543|5776->2548|5969->2713|5998->2714|6158->2847|6187->2848|6232->2865|6261->2866|6330->2906|6360->2907|6570->3089|6599->3090|6669->3131|6699->3132|6759->3164|6788->3165|6860->3208|6890->3209|7002->3292|7032->3293|7122->3354|7152->3355|7221->3387|7235->3391|7262->3395|7308->3412|7338->3413|7390->3437|7420->3438|7454->3444|7483->3445|7552->3485|7582->3486|7664->3539|7694->3540|7764->3573|7778->3577|7805->3581|7871->3618|7901->3619|8009->3698|8039->3699|8192->3824|8222->3825|8257->3832|8286->3833|8356->3874|8386->3875|8468->3928|8498->3929|8569->3963|8583->3967|8610->3971|8677->4009|8707->4010|8751->4026|8780->4027|8848->4066|8878->4067|8929->4081|8943->4085|8978->4097|9022->4104|9036->4108|9065->4114|9096->4116|9126->4117|9212->4175|9242->4176|9275->4181|9304->4182|9378->4227|9408->4228|9474->4257|9488->4261|9523->4273|9567->4280|9581->4284|9610->4290|9642->4293|9672->4294|9845->4438|9875->4439|9935->4470|9965->4471|10190->4667|10220->4668|10266->4685|10296->4686|10363->4724|10393->4725|10519->4822|10549->4823|10647->4892|10677->4893|10723->4910|10753->4911|10805->4935|10835->4936|10897->4961|10911->4965|10946->4977|10990->4984|11004->4988|11033->4994|11064->4996|11094->4997|11248->5122|11278->5123|11338->5154|11368->5155|11589->5347|11619->5348|11665->5365|11695->5366|11762->5404|11792->5405|11918->5502|11948->5503|12046->5572|12076->5573|12122->5590|12152->5591|12204->5615|12234->5616|12296->5641|12310->5645|12345->5657|12389->5664|12403->5668|12432->5674|12463->5676|12493->5677|12647->5802|12677->5803|12737->5834|12767->5835|12988->6027|13018->6028|13064->6045|13094->6046|13161->6084|13191->6085|13317->6182|13347->6183|13445->6252|13475->6253|13521->6270|13551->6271|13603->6295|13633->6296|13695->6321|13709->6325|13744->6337|13788->6344|13802->6348|13831->6354|13862->6356|13892->6357|14046->6482|14076->6483|14136->6514|14166->6515|14391->6711|14421->6712|14467->6729|14497->6730|14564->6768|14594->6769|14720->6866|14750->6867|14848->6936|14878->6937|14924->6954|14954->6955|15006->6979|15036->6980|15069->6985|15098->6986|15157->7008|15171->7012|15199->7017|15231->7021|15260->7022
                    LINES: 19->1|22->1|24->3|24->3|27->6|27->6|27->6|30->9|30->9|32->11|32->11|32->11|32->11|35->14|35->14|37->16|37->16|41->20|41->20|42->21|42->21|42->21|43->22|43->22|46->25|46->25|50->29|50->29|52->31|52->31|53->32|53->32|53->32|53->32|53->32|53->32|54->33|54->33|54->33|54->33|54->33|54->33|54->33|54->33|54->33|55->34|55->34|57->36|57->36|58->37|58->37|58->37|61->40|61->40|63->42|63->42|65->44|65->44|65->44|68->47|68->47|71->50|71->50|72->51|72->51|72->51|75->54|75->54|77->56|77->56|78->57|78->57|78->57|78->57|78->57|78->57|78->57|78->57|80->59|80->59|82->61|82->61|84->63|84->63|88->67|88->67|90->69|90->69|92->71|92->71|96->75|96->75|101->80|101->80|101->80|101->80|103->82|103->82|110->89|110->89|110->89|115->94|115->94|119->98|119->98|121->100|121->100|123->102|123->102|129->108|129->108|131->110|131->110|133->112|133->112|135->114|135->114|137->116|137->116|139->118|139->118|140->119|140->119|140->119|141->120|141->120|143->122|143->122|145->124|145->124|147->126|147->126|149->128|149->128|150->129|150->129|150->129|152->131|152->131|155->134|155->134|160->139|160->139|161->140|161->140|163->142|163->142|165->144|165->144|166->145|166->145|166->145|168->147|168->147|170->149|170->149|172->151|172->151|173->152|173->152|173->152|173->152|173->152|173->152|173->152|173->152|175->154|175->154|176->155|176->155|178->157|178->157|179->158|179->158|179->158|179->158|179->158|179->158|179->158|179->158|184->163|184->163|185->164|185->164|188->167|188->167|189->168|189->168|190->169|190->169|192->171|192->171|194->173|194->173|195->174|195->174|197->176|197->176|197->176|197->176|197->176|197->176|197->176|197->176|197->176|197->176|202->181|202->181|203->182|203->182|206->185|206->185|207->186|207->186|208->187|208->187|210->189|210->189|212->191|212->191|213->192|213->192|215->194|215->194|215->194|215->194|215->194|215->194|215->194|215->194|215->194|215->194|220->199|220->199|221->200|221->200|224->203|224->203|225->204|225->204|226->205|226->205|228->207|228->207|230->209|230->209|231->210|231->210|233->212|233->212|233->212|233->212|233->212|233->212|233->212|233->212|233->212|233->212|238->217|238->217|239->218|239->218|242->221|242->221|243->222|243->222|244->223|244->223|246->225|246->225|248->227|248->227|249->228|249->228|251->230|251->230|252->231|252->231|254->233|254->233|254->233|256->235|256->235
                    -- GENERATED --
                */
            