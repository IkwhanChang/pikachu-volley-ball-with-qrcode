
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
object controller extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
        <link rel="apple-touch-icon" sizes="196x196" href="http://www.matthewlab.com/icon_ngx.png">
        <meta name="mobile-web-app-capable" content="yes">
        <link rel="icon" sizes="196x196" href="http://www.matthewlab.com/icon_ngx.png">
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css">
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>

        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("js/addtohomescreen.min.js"))),format.raw/*14.68*/(""""></script>


        <script type="text/javascript" src=""""),_display_(Seq[Any](/*17.46*/routes/*17.52*/.Application.javascriptRoutes)),format.raw/*17.81*/(""""></script>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Content-Language" content="en" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0;">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <title>Canvas</title>


    </head>

    <body>
        <div id="fb-root"></div>
        <script type="text/javascript">
        $(window).bind("orientationchange", function() """),format.raw/*31.56*/("""{"""),format.raw/*31.57*/("""
        var orientation = window.orientation;
        var new_orientation = (orientation) ? 0 : 90 + orientation;
        $('body').css("""),format.raw/*34.23*/("""{"""),format.raw/*34.24*/("""
        "-webkit-transform" : "rotate(" + new_orientation + "deg)"
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/(""");
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/(""");

        $(document).ready(function() """),format.raw/*39.38*/("""{"""),format.raw/*39.39*/("""
        var start_x;
        var start_y;
        var temp_x;
        var temp_y;
        var move_x;
        var move_y;
        var action_x;
        var action_y;
        var left = 0;

        var myInfo;

        var addr = "165.194.111.154";



        $("#btn-touch").bind('touchstart',function(e) """),format.raw/*56.55*/("""{"""),format.raw/*56.56*/("""
        e.preventDefault(); //	이벤트취소

        var event = e.originalEvent;

//        $("#temp_msg").html("터치가 시작되었어요.");

        start_x = event.touches[0].pageX;
        start_y = event.touches[0].pageY;
        temp_x = event.touches[0].pageX;
        temp_y = event.touches[0].pageY;

        //$('#msg').append('<div>' + id + '/' + '(' + start_x + ',' + start_y + ')' + left + '</div>');



        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/(""");

        $(document).on('touchmove', function(e) """),format.raw/*74.49*/("""{"""),format.raw/*74.50*/("""

            e.preventDefault(); //	이벤트취소
        """),format.raw/*77.9*/("""}"""),format.raw/*77.10*/(""");

        $("#btn-touch").bind('touchmove',function(e) """),format.raw/*79.54*/("""{"""),format.raw/*79.55*/("""

        //                    	jQuery 이벤트 객체를 자바스크립트 표준 이벤트 객체로 바꾸기

        //	이유는 jQuery 에서 자바 스크립트


        var event = e.originalEvent;

        var distinction_x;
        var distinction_y;

        //$('#msg').html('touch 이벤트 중입니다.');

        //	div에 터치한 좌표값 넣기

        move_x = event.touches[0].pageX;
        move_y = event.touches[0].pageY;

        //$('#msg').append(                                                                                                       '<div>' + id + '(MOVE : ' + move_x + ','+ move_y + ')' + '</div>');
        distinction_x = (move_x - temp_x)*2;
        distinction_y = move_y - temp_y;

//        $("#temp_msg" ).append("x : "+distinction_x+" y : "+distinction_y);
//        alert("1");
        $.callAjax(distinction_x, 0);

        temp_x = move_x;
        temp_y = move_y;

        """),format.raw/*109.9*/("""}"""),format.raw/*109.10*/(""");

        $("#btn-touch").bind('touchend', function(e) """),format.raw/*111.54*/("""{"""),format.raw/*111.55*/("""
        e.preventDefault(); //	이벤트취소

        var event = e.originalEvent;

//        $("#temp_msg").append("<div>터치이벤트가 종료되었어요</div>");

        //$('#msg').append('<div>' + id + '/' + '(' + start_x + ',' + start_y + ')' + '</div>');

        """),format.raw/*120.9*/("""}"""),format.raw/*120.10*/(""");


        $.callAjax = function(x,y) """),format.raw/*123.36*/("""{"""),format.raw/*123.37*/("""
            //$("#temp_msg").html(jsRoutes.controllers.User.setUserXY(myInfo.id,x,y));


            $.ajax(
                jsRoutes.controllers.User.setUserXY(myInfo.id,x,0)
            ).done(function(data)"""),format.raw/*129.34*/("""{"""),format.raw/*129.35*/("""
                //alert(data.msg);
                console.log(data);
            """),format.raw/*132.13*/("""}"""),format.raw/*132.14*/(""").fail(function(e)"""),format.raw/*132.32*/("""{"""),format.raw/*132.33*/("""
                //alert(e);
                console.log(e);
            """),format.raw/*135.13*/("""}"""),format.raw/*135.14*/(""");

        """),format.raw/*137.9*/("""}"""),format.raw/*137.10*/("""

            $("#btn-jump" ).click(function(e) """),format.raw/*139.47*/("""{"""),format.raw/*139.48*/("""
                $.ajax(
                jsRoutes.controllers.User.JumpUser(myInfo.id)
                ).done(function(data)"""),format.raw/*142.38*/("""{"""),format.raw/*142.39*/("""
                //alert(data.msg);
                console.log(data);
                """),format.raw/*145.17*/("""}"""),format.raw/*145.18*/(""").fail(function(e)"""),format.raw/*145.36*/("""{"""),format.raw/*145.37*/("""
                //alert(e);
                console.log(e);
                """),format.raw/*148.17*/("""}"""),format.raw/*148.18*/(""");
            """),format.raw/*149.13*/("""}"""),format.raw/*149.14*/(""");

        $("#btn-shoot" ).click(function(e) """),format.raw/*151.44*/("""{"""),format.raw/*151.45*/("""
        $.ajax(
        jsRoutes.controllers.User.ShootUser(myInfo.id)
        ).done(function(data)"""),format.raw/*154.30*/("""{"""),format.raw/*154.31*/("""
        //alert(data.msg);
        console.log(data);
        """),format.raw/*157.9*/("""}"""),format.raw/*157.10*/(""").fail(function(e)"""),format.raw/*157.28*/("""{"""),format.raw/*157.29*/("""
        //alert(e);
        console.log(e);
        """),format.raw/*160.9*/("""}"""),format.raw/*160.10*/(""");
        """),format.raw/*161.9*/("""}"""),format.raw/*161.10*/(""");


        $.ajaxSetup("""),format.raw/*164.21*/("""{"""),format.raw/*164.22*/(""" cache: true """),format.raw/*164.35*/("""}"""),format.raw/*164.36*/(""");
        $.getScript('//connect.facebook.net/en_UK/all.js', function()"""),format.raw/*165.70*/("""{"""),format.raw/*165.71*/("""
        FB.init("""),format.raw/*166.17*/("""{"""),format.raw/*166.18*/("""
        appId      : '236220253168811', // Original
        //appId      : '243183015805868', // Sangtae
        //appId       : '241309625993207', // Matthew Test
        cookie     : true,  // enable cookies to allow the server to access
        status: true,
        // the session
        xfbml      : true,  // parse social plugins on this page
        version    : 'v2.0' // use version 2.0
        """),format.raw/*175.9*/("""}"""),format.raw/*175.10*/(""");

        //$('#loginbutton,#feedbutton').removeAttr('disabled');
        FB.getLoginStatus( $.statusChangeCallback);
        """),format.raw/*179.9*/("""}"""),format.raw/*179.10*/(""");

        $.statusChangeCallback = function(response)"""),format.raw/*181.52*/("""{"""),format.raw/*181.53*/("""
        console.log('statusChangeCallback');
        console.log(response);
        if (response.status === 'connected') """),format.raw/*184.46*/("""{"""),format.raw/*184.47*/("""

        $.addMe(response);
        //drawGame();

        // 1. Get My Profile

        // 2. Get Friend List
        """),format.raw/*192.9*/("""}"""),format.raw/*192.10*/(""" else if (response.status === 'not_authorized') """),format.raw/*192.58*/("""{"""),format.raw/*192.59*/("""
        $('.div-msg #msg' ).html('Please login using Facebook login button.');
        $('.div-msg' ).fadeIn();
        """),format.raw/*195.9*/("""}"""),format.raw/*195.10*/(""" else """),format.raw/*195.16*/("""{"""),format.raw/*195.17*/("""
        $('.div-msg #msg' ).html('Please login using Facebook login button.');
        $('.div-msg' ).fadeIn();
        """),format.raw/*198.9*/("""}"""),format.raw/*198.10*/("""
        """),format.raw/*199.9*/("""}"""),format.raw/*199.10*/("""

        $.addMe = function(e) """),format.raw/*201.31*/("""{"""),format.raw/*201.32*/("""

        FB.api('/me', function(response) """),format.raw/*203.42*/("""{"""),format.raw/*203.43*/("""
        $("#login_status_msg" ).html(response.name+"님 환영합니다.");
        $("#fbBtn" ).hide();

        myInfo = response;

        FB.api(
        'me?fields=picture.width(160).height(160).type(square)',
        function(response2) """),format.raw/*211.29*/("""{"""),format.raw/*211.30*/("""
            myProfile_url = response2.picture.data.url;

        """),format.raw/*214.9*/("""}"""),format.raw/*214.10*/(""");



        """),format.raw/*218.9*/("""}"""),format.raw/*218.10*/(""");
        """),format.raw/*219.9*/("""}"""),format.raw/*219.10*/("""

        function checkLoginStatus() """),format.raw/*221.37*/("""{"""),format.raw/*221.38*/("""
        FB.getLoginStatus(function(response) """),format.raw/*222.46*/("""{"""),format.raw/*222.47*/("""
        $.statusChangeCallback(response);
        """),format.raw/*224.9*/("""}"""),format.raw/*224.10*/(""");
        """),format.raw/*225.9*/("""}"""),format.raw/*225.10*/("""

            //btn-touch

        $("#layer-touch" ).css("width",($(window ).width() * 0.60)+"px");

        $("#layer-jump" ).css("width",($(window ).width() * 0.25)+"px");
        $("#layer-shoot" ).css("width",($(window ).width() * 0.25)+"px");

        $("#layer-jump" ).css("height",($(window ).height() * 0.30)+"px");
        $("#layer-shoot" ).css("height",($(window ).height() * 0.30)+"px");



            $(window ).on("orientationchange",function() """),format.raw/*239.58*/("""{"""),format.raw/*239.59*/("""


            $("#layer-touch" ).css("width",($(window ).width() * 0.60)+"px");

            $("#layer-jump" ).css("width",($(window ).width() * 0.25)+"px");
            $("#layer-shoot" ).css("width",($(window ).width() * 0.25)+"px");

            $("#layer-jump" ).css("height",($(window ).height() * 0.30)+"px");
            $("#layer-shoot" ).css("height",($(window ).height() * 0.30)+"px");

            $.checkRotate();

            """),format.raw/*252.13*/("""}"""),format.raw/*252.14*/(""");

        $.checkRotate = function() """),format.raw/*254.36*/("""{"""),format.raw/*254.37*/("""
        var orientation = window.orientation;
        //alert(orientation);

        switch (orientation)
        """),format.raw/*259.9*/("""{"""),format.raw/*259.10*/("""
        case 0:
        showRotateNotice();
        break;
        case -90:

        hideRotateNotice();

        break;
        case 90:

        hideRotateNotice();

        break;
        """),format.raw/*273.9*/("""}"""),format.raw/*273.10*/("""
        """),format.raw/*274.9*/("""}"""),format.raw/*274.10*/("""


        function showRotateNotice()
        """),format.raw/*278.9*/("""{"""),format.raw/*278.10*/("""
            $("#main_controller" ).fadeOut();
            $("#main_msg" ).fadeIn();
        """),format.raw/*281.9*/("""}"""),format.raw/*281.10*/("""

        function hideRotateNotice()
        """),format.raw/*284.9*/("""{"""),format.raw/*284.10*/("""
            $("#main_msg" ).fadeOut();
        $("#main_controller" ).fadeIn();
        """),format.raw/*287.9*/("""}"""),format.raw/*287.10*/("""

        $.checkRotate();

        """),format.raw/*291.9*/("""}"""),format.raw/*291.10*/(""");




        </script>
        <div data-role="page" id="main">
            <div data-role="header">
                <h1>FBVOL_CLIENT</h1>
            </div><!-- /header -->

            <div role="main" class="ui-content">
                    <!--<p><a href="#controller" class="ui-btn ui-shadow ui-corner-all">Facebook Login</a></p>-->
                <p><fb:login-button scope="public_profile,email,user_friends,manage_friendlists" size="large" max_rows="1" onlogin="checkLoginStatus();" id="fbBtn">
                                </fb:login-button></p>

                <p class="div-msg">
                    <h3 id="login_status_msg"></h3>
                </p>
                <p><a href="#controller" class="ui-btn ui-shadow ui-corner-all">NGX Controller</a></p>
            </div><!-- /content -->

            <div data-role="footer">
                <h4>Copyright <a href="http://www.izectlab.com">www.izectlab.com</a><br/>
                    Developed by Team NGX in CAUCSE</h4>
            </div><!-- /footer -->
        </div>

            <!-- Start of second page -->
        <div data-role="page" id="controller">

            <div data-role="header">
                <h1>NGX Controller</h1>
            </div><!-- /header -->
            <div role="main" class="ui-content">
                <div class="ui-grid-b"  id="main_controller">
                    <div class="ui-block-a" id="layer-touch"   style="height:60%" style="width:49.95%;"><canvas   style="height:80%" class="ui-block-a" id="btn-touch">Touch</canvas></div>
                    <div class="ui-block-b" id="layer-jump" ><div style="height:100%"    class="ui-bar ui-bar-a" id="btn-jump">Jump</div></div>
                    <div class="ui-block-c" id="layer-shoot" ><div  style="height:100%"   class="ui-bar ui-bar-a" id="btn-shoot">Shoot</div></div>
                </div><!-- /grid-b -->

                <div id="main_msg" style="display: none;">
                    <h1>please rotate your controller!!</h1>
                </div>
            </div><!-- /content -->

            <div data-role="footer">
                <h4>Copyright <a href="http://www.matthewlab.com">www.matthewlab.com</a><br/>
                    Developed by Team NGX in CAUCSE</h4>
            </div><!-- /footer -->
        </div><!-- /page -->

    </body>

</html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 17:22:52 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/controller.scala.html
                    HASH: ad5cd0f83096141b3d53ef280b14df3cdae43da4
                    MATRIX: 642->0|1505->827|1520->833|1581->872|1676->931|1691->937|1742->966|2343->1539|2372->1540|2537->1677|2566->1678|2669->1754|2698->1755|2736->1766|2765->1767|2834->1808|2863->1809|3197->2115|3226->2116|3659->2522|3688->2523|3768->2575|3797->2576|3875->2627|3904->2628|3989->2685|4018->2686|4885->3525|4915->3526|5001->3583|5031->3584|5304->3829|5334->3830|5403->3870|5433->3871|5672->4081|5702->4082|5814->4165|5844->4166|5891->4184|5921->4185|6023->4258|6053->4259|6093->4271|6123->4272|6200->4320|6230->4321|6383->4445|6413->4446|6529->4533|6559->4534|6606->4552|6636->4553|6742->4630|6772->4631|6816->4646|6846->4647|6922->4694|6952->4695|7082->4796|7112->4797|7203->4860|7233->4861|7280->4879|7310->4880|7391->4933|7421->4934|7460->4945|7490->4946|7544->4971|7574->4972|7616->4985|7646->4986|7747->5058|7777->5059|7823->5076|7853->5077|8287->5483|8317->5484|8473->5612|8503->5613|8587->5668|8617->5669|8768->5791|8798->5792|8946->5912|8976->5913|9053->5961|9083->5962|9232->6083|9262->6084|9297->6090|9327->6091|9476->6212|9506->6213|9543->6222|9573->6223|9634->6255|9664->6256|9736->6299|9766->6300|10027->6532|10057->6533|10151->6599|10181->6600|10223->6614|10253->6615|10292->6626|10322->6627|10389->6665|10419->6666|10494->6712|10524->6713|10603->6764|10633->6765|10672->6776|10702->6777|11192->7238|11222->7239|11691->7679|11721->7680|11789->7719|11819->7720|11962->7835|11992->7836|12213->8029|12243->8030|12280->8039|12310->8040|12385->8087|12415->8088|12536->8181|12566->8182|12640->8228|12670->8229|12787->8318|12817->8319|12881->8355|12911->8356
                    LINES: 22->1|35->14|35->14|35->14|38->17|38->17|38->17|52->31|52->31|55->34|55->34|57->36|57->36|58->37|58->37|60->39|60->39|77->56|77->56|93->72|93->72|95->74|95->74|98->77|98->77|100->79|100->79|130->109|130->109|132->111|132->111|141->120|141->120|144->123|144->123|150->129|150->129|153->132|153->132|153->132|153->132|156->135|156->135|158->137|158->137|160->139|160->139|163->142|163->142|166->145|166->145|166->145|166->145|169->148|169->148|170->149|170->149|172->151|172->151|175->154|175->154|178->157|178->157|178->157|178->157|181->160|181->160|182->161|182->161|185->164|185->164|185->164|185->164|186->165|186->165|187->166|187->166|196->175|196->175|200->179|200->179|202->181|202->181|205->184|205->184|213->192|213->192|213->192|213->192|216->195|216->195|216->195|216->195|219->198|219->198|220->199|220->199|222->201|222->201|224->203|224->203|232->211|232->211|235->214|235->214|239->218|239->218|240->219|240->219|242->221|242->221|243->222|243->222|245->224|245->224|246->225|246->225|260->239|260->239|273->252|273->252|275->254|275->254|280->259|280->259|294->273|294->273|295->274|295->274|299->278|299->278|302->281|302->281|305->284|305->284|308->287|308->287|312->291|312->291
                    -- GENERATED --
                */
            