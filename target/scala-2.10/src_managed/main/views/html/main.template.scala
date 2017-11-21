
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Option[User],Option[Room],Int,Option[User],Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: Option[User],room:Option[Room],now_menu:Int,enemy:Option[User]=null)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.92*/("""

<!DOCTYPE html>

<html xmlns:fb="http://ogp.me/ns/fb#">
    <head>
        <title>FACEBOOK REMOTE VOLLEY BALL</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <!-- Bootstrap -->

        <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" language="javascript" src="//cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="//cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>

            <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

            <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

            <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

        <script type="text/javascript" src=""""),_display_(Seq[Any](/*24.46*/routes/*24.52*/.Application.javascriptRoutes)),format.raw/*24.81*/(""""></script>

        <script type="text/javascript" src="//d3lp1msu2r81bx.cloudfront.net/kjs/js/lib/kinetic-v5.1.0.min.js"></script>

        <script src="//connect.facebook.net/en_US/sdk.js"></script>

    </head>
    <body>
        <div id="fb-root"></div>
        <script>


            var myInfo;
            var myProfile_url;
            var friendList;

            $(document ).ready(function() """),format.raw/*40.43*/("""{"""),format.raw/*40.44*/("""

            function checkLoginState() """),format.raw/*42.40*/("""{"""),format.raw/*42.41*/("""
            FB.getLoginStatus(function(response) """),format.raw/*43.50*/("""{"""),format.raw/*43.51*/("""
            $.statusChangeCallback(response);
            """),format.raw/*45.13*/("""}"""),format.raw/*45.14*/(""");
            """),format.raw/*46.13*/("""}"""),format.raw/*46.14*/("""


                """),_display_(Seq[Any](/*49.18*/if(user == null)/*49.34*/{_display_(Seq[Any](format.raw/*49.35*/("""
                $.ajaxSetup("""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/(""" cache: true """),format.raw/*50.43*/("""}"""),format.raw/*50.44*/(""");
                $.getScript('//connect.facebook.net/en_UK/all.js', function()"""),format.raw/*51.78*/("""{"""),format.raw/*51.79*/("""
                    FB.init("""),format.raw/*52.29*/("""{"""),format.raw/*52.30*/("""
                    appId      : '236220253168811', // Original
                    //appId      : '243183015805868', // Sangtae
                    //appId       : '241309625993207', // Matthew Test
                        frictionlessRequests: true,
                        status: true,
                        version: 'v2.0'

                    """),format.raw/*60.21*/("""}"""),format.raw/*60.22*/(""");

                    FB.Event.subscribe('auth.authResponseChange', onAuthResponseChange);
                    FB.Event.subscribe('auth.statusChange', onStatusChange);

                    //$('#loginbutton,#feedbutton').removeAttr('disabled');
                    //FB.getLoginStatus( $.statusChangeCallback);
                """),format.raw/*67.17*/("""}"""),format.raw/*67.18*/(""");

                function login(callback) """),format.raw/*69.42*/("""{"""),format.raw/*69.43*/("""
                    FB.login(callback);
                """),format.raw/*71.17*/("""}"""),format.raw/*71.18*/("""
                function loginCallback(response) """),format.raw/*72.50*/("""{"""),format.raw/*72.51*/("""
                    console.log('loginCallback',response);
                    if(response.status != 'connected') """),format.raw/*74.56*/("""{"""),format.raw/*74.57*/("""
                        top.location.href = 'https://www.facebook.com/appcenter/236220253168811';
                    """),format.raw/*76.21*/("""}"""),format.raw/*76.22*/("""
                """),format.raw/*77.17*/("""}"""),format.raw/*77.18*/("""
                function onStatusChange(response) """),format.raw/*78.51*/("""{"""),format.raw/*78.52*/("""
                    if( response.status != 'connected' ) """),format.raw/*79.58*/("""{"""),format.raw/*79.59*/("""
                        login(loginCallback);
                    """),format.raw/*81.21*/("""}"""),format.raw/*81.22*/(""" else """),format.raw/*81.28*/("""{"""),format.raw/*81.29*/("""
                        //showHome();
                        $.statusChangeCallback(response);
                    """),format.raw/*84.21*/("""}"""),format.raw/*84.22*/("""
                """),format.raw/*85.17*/("""}"""),format.raw/*85.18*/("""
                function onAuthResponseChange(response) """),format.raw/*86.57*/("""{"""),format.raw/*86.58*/("""
                    console.log('onAuthResponseChange', response);
                """),format.raw/*88.17*/("""}"""),format.raw/*88.18*/("""

            $.statusChangeCallback = function(response)"""),format.raw/*90.56*/("""{"""),format.raw/*90.57*/("""
                console.log('statusChangeCallback');
                console.log(response);
                if (response.status === 'connected') """),format.raw/*93.54*/("""{"""),format.raw/*93.55*/("""

                    $.addMe(response);
                    //drawGame();

                    // 1. Get My Profile

                    // 2. Get Friend List
                """),format.raw/*101.17*/("""}"""),format.raw/*101.18*/(""" else if (response.status === 'not_authorized') """),format.raw/*101.66*/("""{"""),format.raw/*101.67*/("""
                    $('.div-msg #msg' ).html('Please login using Facebook login button.');
                    $('.div-msg' ).fadeIn();
                """),format.raw/*104.17*/("""}"""),format.raw/*104.18*/(""" else """),format.raw/*104.24*/("""{"""),format.raw/*104.25*/("""
                    $('.div-msg #msg' ).html('Please login using Facebook login button.');
                    $('.div-msg' ).fadeIn();
                """),format.raw/*107.17*/("""}"""),format.raw/*107.18*/("""
            """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/("""

            $.checkLoginStatus = function() """),format.raw/*110.45*/("""{"""),format.raw/*110.46*/("""
            FB.getLoginStatus(function(response) """),format.raw/*111.50*/("""{"""),format.raw/*111.51*/("""
            $.statusChangeCallback(response);
            """),format.raw/*113.13*/("""}"""),format.raw/*113.14*/(""");
            """),format.raw/*114.13*/("""}"""),format.raw/*114.14*/("""



            $.addMe = function(e) """),format.raw/*118.35*/("""{"""),format.raw/*118.36*/("""

                FB.api('/me', function(response) """),format.raw/*120.50*/("""{"""),format.raw/*120.51*/("""
                $('#display_progress .progress-bar' ).css('width','30%');
                    $("#login_status_msg" ).html(response.name+"님 환영합니다.");
                    $("#fbBtn" ).hide();
                    myInfo = response;
                $.setUserStatusByToken("1");
                    FB.api(
                        'me?fields=picture.width(160).height(160).type(square)',
                        function(response2) """),format.raw/*128.45*/("""{"""),format.raw/*128.46*/("""
                            console.log(response2);
                        $('#display_progress .progress-bar' ).css('width','45%');
                            myProfile_url = response2.picture.data.url;
                            $.ajax(
                                jsRoutes.controllers.User.addUser(
                                    response.name,
                                    response.email,
                                    response2.picture.data.url,
                                    response2.id
                                )
                            ).done(function(data)"""),format.raw/*139.50*/("""{"""),format.raw/*139.51*/("""
                                console.log(data.code);
                            $('#display_progress .progress-bar' ).css('width','100%');
                            $('#form1 input[id=token]' ).val(response.id);
                            $('#form1' ).submit();

                            """),format.raw/*145.29*/("""}"""),format.raw/*145.30*/(""" ).fail(function(e)"""),format.raw/*145.49*/("""{"""),format.raw/*145.50*/("""
                                console.log(e);
                            """),format.raw/*147.29*/("""}"""),format.raw/*147.30*/(""")
                        """),format.raw/*148.25*/("""}"""),format.raw/*148.26*/(""");



                """),format.raw/*152.17*/("""}"""),format.raw/*152.18*/(""");
            """),format.raw/*153.13*/("""}"""),format.raw/*153.14*/("""

            $.getRooms = function() """),format.raw/*155.37*/("""{"""),format.raw/*155.38*/("""
                $.ajax(
                    jsRoutes.controllers.Room.getRooms()
                    ).done(function(data)"""),format.raw/*158.42*/("""{"""),format.raw/*158.43*/("""
                        console.log(data);
                        $('#tbl_room_list' ).append(data);
                        $('#display_progress .progress-bar' ).css('width','100%');
                        $('#display_progress' ).hide();
                        $('#room_main' ).fadeIn();
                        $('#btn-join-room' ).click(function(e)"""),format.raw/*164.63*/("""{"""),format.raw/*164.64*/("""
                            //$.setUserProfile(myInfo.id,'game_my_profile');
                            $.setPlayersProfile($(this ).data('roomSeq'));
                            $.setUserStatusByToken("2");
                            $.setUserCurrentRoom($(this ).data('roomSeq'));
                            var title = "["+$(this ).data('roomSeq')+"] "+$(this ).data('roomTitle')
                            $('#room_title' ).html(title);


                            $('#display_room' ).fadeOut(500,function() """),format.raw/*173.72*/("""{"""),format.raw/*173.73*/("""

                                $('#display_game' ).fadeIn(500, function() """),format.raw/*175.76*/("""{"""),format.raw/*175.77*/("""

                                """),format.raw/*177.33*/("""}"""),format.raw/*177.34*/(""");
                            """),format.raw/*178.29*/("""}"""),format.raw/*178.30*/(""");

                        $('#btn-exit-room' ).click(function()"""),format.raw/*180.62*/("""{"""),format.raw/*180.63*/("""
                            if(confirm("Do you really want to exit game?"))"""),format.raw/*181.76*/("""{"""),format.raw/*181.77*/("""
                                $.setUserStatusByToken("1");
                                $.setUserCurrentRoom("0");
                                $('#display_game' ).fadeOut(500,function() """),format.raw/*184.76*/("""{"""),format.raw/*184.77*/("""
                                    $('#display_room' ).fadeIn();
                                """),format.raw/*186.33*/("""}"""),format.raw/*186.34*/(""");
                            """),format.raw/*187.29*/("""}"""),format.raw/*187.30*/("""

                        """),format.raw/*189.25*/("""}"""),format.raw/*189.26*/(""");


                        """),format.raw/*192.25*/("""}"""),format.raw/*192.26*/(""");

                    """),format.raw/*194.21*/("""}"""),format.raw/*194.22*/(""").fail(function(e)"""),format.raw/*194.40*/("""{"""),format.raw/*194.41*/("""
                        console.log(e);
                """),format.raw/*196.17*/("""}"""),format.raw/*196.18*/(""");

            """),format.raw/*198.13*/("""}"""),format.raw/*198.14*/("""

            $.setUserStatusByToken = function(status)"""),format.raw/*200.54*/("""{"""),format.raw/*200.55*/("""
                $.ajax(
                    jsRoutes.controllers.User.setUserStatusByToken(status,myInfo.id)
                ).done(function(data)"""),format.raw/*203.38*/("""{"""),format.raw/*203.39*/("""
                    console.log(data);
                """),format.raw/*205.17*/("""}"""),format.raw/*205.18*/(""").fail(function(e)"""),format.raw/*205.36*/("""{"""),format.raw/*205.37*/("""
                    console.log(e);
                """),format.raw/*207.17*/("""}"""),format.raw/*207.18*/(""");
            """),format.raw/*208.13*/("""}"""),format.raw/*208.14*/("""

            $.setUserCurrentRoom = function(seq)"""),format.raw/*210.49*/("""{"""),format.raw/*210.50*/("""
                $.ajax(
                    jsRoutes.controllers.User.setUserCurrentRoom(seq,myInfo.id)
                ).done(function(data)"""),format.raw/*213.38*/("""{"""),format.raw/*213.39*/("""
                    console.log(data);
                """),format.raw/*215.17*/("""}"""),format.raw/*215.18*/(""").fail(function(e)"""),format.raw/*215.36*/("""{"""),format.raw/*215.37*/("""
                    console.log(e);
                """),format.raw/*217.17*/("""}"""),format.raw/*217.18*/(""");
            """),format.raw/*218.13*/("""}"""),format.raw/*218.14*/("""
            $.setPlayersProfile = function(seq)"""),format.raw/*219.48*/("""{"""),format.raw/*219.49*/("""
                $.ajax(
                    jsRoutes.controllers.Room.getPlayersProfile(seq,myInfo.id)
                ).done(function(data)"""),format.raw/*222.38*/("""{"""),format.raw/*222.39*/("""
                    console.log(data);
                    $("#game_player_profile").append(data);
                """),format.raw/*225.17*/("""}"""),format.raw/*225.18*/(""").fail(function(e)"""),format.raw/*225.36*/("""{"""),format.raw/*225.37*/("""
                    console.log(e);
                """),format.raw/*227.17*/("""}"""),format.raw/*227.18*/(""");
            """),format.raw/*228.13*/("""}"""),format.raw/*228.14*/("""

            $.setProfile = function() """),format.raw/*230.39*/("""{"""),format.raw/*230.40*/("""
                $.ajax(
                    jsRoutes.controllers.User.getUserProfile(myInfo.id)
                ).done(function(data)"""),format.raw/*233.38*/("""{"""),format.raw/*233.39*/("""
                    console.log(data);
                $('#display_progress .progress-bar' ).css('width','70%');
                    $('#my_profile' ).append(data);
                    $('#profile_main' ).fadeIn();
                """),format.raw/*238.17*/("""}"""),format.raw/*238.18*/(""").fail(function(e)"""),format.raw/*238.36*/("""{"""),format.raw/*238.37*/("""
                    console.log(e);
                """),format.raw/*240.17*/("""}"""),format.raw/*240.18*/(""");

            //$('#my_profile' ).append('<div class="span4"><img src="'+myProfile_url+'" /></div><div class="span8"><h5>'+myInfo.name+'</h5>Win : '+myInfo.win+'</div>');

            """),format.raw/*244.13*/("""}"""),format.raw/*244.14*/("""

            """)))})),format.raw/*246.14*/("""


            """),_display_(Seq[Any](/*249.14*/if(user != null)/*249.30*/{_display_(Seq[Any](format.raw/*249.31*/("""
                $.ajaxSetup("""),format.raw/*250.29*/("""{"""),format.raw/*250.30*/(""" cache: true """),format.raw/*250.43*/("""}"""),format.raw/*250.44*/(""");
                $.getScript('//connect.facebook.net/en_UK/all.js', function()"""),format.raw/*251.78*/("""{"""),format.raw/*251.79*/("""
                FB.init("""),format.raw/*252.25*/("""{"""),format.raw/*252.26*/("""
                appId      : '236220253168811', // Original
                //appId      : '243183015805868', // Sangtae
                //appId       : '241309625993207', // Matthew Test
                frictionlessRequests: true,
                status: true,
                version: 'v2.0'

                """),format.raw/*260.17*/("""}"""),format.raw/*260.18*/(""");

                FB.Event.subscribe('auth.authResponseChange', onAuthResponseChange);
                FB.Event.subscribe('auth.statusChange', onStatusChange);

                //$('#loginbutton,#feedbutton').removeAttr('disabled');
                //FB.getLoginStatus( $.statusChangeCallback);
                """),format.raw/*267.17*/("""}"""),format.raw/*267.18*/(""");

                function login(callback) """),format.raw/*269.42*/("""{"""),format.raw/*269.43*/("""
                FB.login(callback);
                """),format.raw/*271.17*/("""}"""),format.raw/*271.18*/("""
                function loginCallback(response) """),format.raw/*272.50*/("""{"""),format.raw/*272.51*/("""
                console.log('loginCallback',response);
                if(response.status != 'connected') """),format.raw/*274.52*/("""{"""),format.raw/*274.53*/("""
                top.location.href = 'https://www.facebook.com/appcenter/236220253168811';
                """),format.raw/*276.17*/("""}"""),format.raw/*276.18*/("""
                """),format.raw/*277.17*/("""}"""),format.raw/*277.18*/("""
                function onStatusChange(response) """),format.raw/*278.51*/("""{"""),format.raw/*278.52*/("""
                if( response.status != 'connected' ) """),format.raw/*279.54*/("""{"""),format.raw/*279.55*/("""
                login(loginCallback);
                """),format.raw/*281.17*/("""}"""),format.raw/*281.18*/(""" else """),format.raw/*281.24*/("""{"""),format.raw/*281.25*/("""
                //showHome();
                $.statusChangeCallback(response);
                """),format.raw/*284.17*/("""}"""),format.raw/*284.18*/("""
                """),format.raw/*285.17*/("""}"""),format.raw/*285.18*/("""
                function onAuthResponseChange(response) """),format.raw/*286.57*/("""{"""),format.raw/*286.58*/("""
                console.log('onAuthResponseChange', response);
                """),format.raw/*288.17*/("""}"""),format.raw/*288.18*/("""

                $.statusChangeCallback = function(response)"""),format.raw/*290.60*/("""{"""),format.raw/*290.61*/("""
                console.log('statusChangeCallback');
                console.log(response);
                if (response.status === 'connected') """),format.raw/*293.54*/("""{"""),format.raw/*293.55*/("""

                //drawGame();

                // 1. Get My Profile
                $("#fbBtn" ).hide();

                // 2. Get Friend List
                """),format.raw/*301.17*/("""}"""),format.raw/*301.18*/(""" else if (response.status === 'not_authorized') """),format.raw/*301.66*/("""{"""),format.raw/*301.67*/("""
                $('.div-msg #msg' ).html('Please login using Facebook login button.');
                $('.div-msg' ).fadeIn();
                """),format.raw/*304.17*/("""}"""),format.raw/*304.18*/(""" else """),format.raw/*304.24*/("""{"""),format.raw/*304.25*/("""
                $('.div-msg #msg' ).html('Please login using Facebook login button.');
                $('.div-msg' ).fadeIn();
                """),format.raw/*307.17*/("""}"""),format.raw/*307.18*/("""
                """),format.raw/*308.17*/("""}"""),format.raw/*308.18*/("""


                $.checkLoginStatus = function() """),format.raw/*311.49*/("""{"""),format.raw/*311.50*/("""
                FB.getLoginStatus(function(response) """),format.raw/*312.54*/("""{"""),format.raw/*312.55*/("""
                $.statusChangeCallback(response);
                """),format.raw/*314.17*/("""}"""),format.raw/*314.18*/(""");
                """),format.raw/*315.17*/("""}"""),format.raw/*315.18*/("""


                $.logOut = function() """),format.raw/*318.39*/("""{"""),format.raw/*318.40*/("""
                FB.logout(function(response) """),format.raw/*319.46*/("""{"""),format.raw/*319.47*/("""
                // Person is now logged out
                location.href="/";
                """),format.raw/*322.17*/("""}"""),format.raw/*322.18*/(""");
                """),format.raw/*323.17*/("""}"""),format.raw/*323.18*/("""

                $("#link-logout" ).click(function() """),format.raw/*325.53*/("""{"""),format.raw/*325.54*/("""
                $.logOut();
                """),format.raw/*327.17*/("""}"""),format.raw/*327.18*/(""");
            """)))})),format.raw/*328.14*/("""
            """),format.raw/*329.13*/("""}"""),format.raw/*329.14*/(""");






        </script>

        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href=""""),_display_(Seq[Any](/*342.52*/routes/*342.58*/.Application.index())),format.raw/*342.78*/("""">FACEBOOK REMOTE VOLLEY BALL</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#"  data-toggle="modal" data-target="#helpModal">Help</a></li>
                        """),_display_(Seq[Any](/*347.26*/if(now_menu == 1 || now_menu == 2)/*347.60*/{_display_(Seq[Any](format.raw/*347.61*/("""
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#" data-toggle="modal" data-target="#modal_makeroom">New Room</a></li>
                                    <li><a href="#">Setting</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#" id="link-logout">Logout</a></li>
                                </ul>
                            </li>
                        """)))})),format.raw/*357.26*/("""
                        <li class="text-center">
                            <fb:login-button scope="public_profile,email,user_friends,manage_friendlists,publish_actions" size="large" max_rows="1" onlogin="checkLoginState" id="fbBtn">
                            </fb:login-button>
                            <span class="label label-success" id="login_status_msg"></span>
                            <form action=""""),_display_(Seq[Any](/*362.44*/routes/*362.50*/.Application.chatRoom(None))),format.raw/*362.77*/("""" class="pull-right" id="form1" style="display: none;">
                                <input id="token" name="token" class="input-small" type="text" placeholder="Username">
                                <button class="btn" type="submit">Sign in</button>
                            </form>
                        </li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        """),_display_(Seq[Any](/*370.26*/if(now_menu == 2 && enemy != null)/*370.60*/{_display_(Seq[Any](format.raw/*370.61*/("""
                            """),_display_(Seq[Any](/*371.30*/views/*371.35*/.html.profile(enemy))),format.raw/*371.55*/("""
                        """)))})),format.raw/*372.26*/("""
                        """),_display_(Seq[Any](/*373.26*/if(user != null)/*373.42*/{_display_(Seq[Any](format.raw/*373.43*/("""
                            """),_display_(Seq[Any](/*374.30*/views/*374.35*/.html.profile(user))),format.raw/*374.54*/("""
                        """)))})),format.raw/*375.26*/("""

                    </ul>
                </div>
            </div>
        </div>
        <div style="height:80px;"></div>
        <div class="container" role="main">
        """),_display_(Seq[Any](/*383.10*/if(room == null && user == null)/*383.42*/{_display_(Seq[Any](format.raw/*383.43*/("""
            <div class="row" id="display_progress">
                <div class="progress progress-striped active">
                    <div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 10%">
                        <span class="sr-only">Loading..</span>
                    </div>
                </div>
                <div class="alert alert-danger fade in div-msg" style="display:none;">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <p id="msg"></p>
                </div>
            </div>
        """)))})),format.raw/*395.10*/("""
            <div class="row" id="display_room">
                """),_display_(Seq[Any](/*397.18*/content)),format.raw/*397.25*/("""
            </div>

            <footer>
                <p>
                    Copyright <a href="http://www.matthewlab.com">www.matthewlab.com</a> All right reserved <br/>
                    Developed by Team NGX in CAUCSE
                </p>
            </footer>

        </div>



            <!-- Modal -->
        <div class="modal fade" id="helpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Help</h4>
                    </div>
                    <div class="modal-body">
                        <h4>What is this game?</h4>
                        <p>NGX FB Volley Ball is simple volley ball game which is controlled by your any kind of smart-phone devices.</p>
                        <h4>How can I get controller?</h4>
                        <p>you can connect <a href="http://c.matthewlab.com" target="_blank">c.matthewlab.com</a> via safari(iPhone) or Chrome(Android) and add to Bookmark to your homescreen.</p>
                        <h4>Game Rule</h4>
                        <p>One on one matching system</p>
                        <p>User can select  15, 18, 21 points as condition for win</p>
                        <p>Passing a ball over a net within three touches</p>
                        <p>User can give up during the game</p>
                        <p>No time limit</p>
                        <h4>Developers</h4>
                        <h5>Lee Sang-Tae(tkdxo0624@naver.com)</h5>
                        <p>Game Client, Database</p>
                        <h5>Matthew Chang(matthew.chang@me.com)</h5>
                        <p>Back-end, Facebook API</p>
                        <h5>Jo Dong-kyoung(dkjo91@gmail.com)</h5>
                        <p>Controller web application</p>
                        <p>Produced by 2014 <a href="http://www.matthewlab.com" target="_blank">Matthew LAB</a></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
"""))}
    }
    
    def render(user:Option[User],room:Option[Room],now_menu:Int,enemy:Option[User],content:Html): play.api.templates.HtmlFormat.Appendable = apply(user,room,now_menu,enemy)(content)
    
    def f:((Option[User],Option[Room],Int,Option[User]) => (Html) => play.api.templates.HtmlFormat.Appendable) = (user,room,now_menu,enemy) => (content) => apply(user,room,now_menu,enemy)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 03 17:02:45 KST 2014
                    SOURCE: /Users/changmatthew/Documents/workspace_play/NEW_FBVOL_PLAY/app/views/main.scala.html
                    HASH: b6bdd613b4092fd31383a1647781e1e5ef1eee82
                    MATRIX: 596->1|780->91|1971->1246|1986->1252|2037->1281|2469->1685|2498->1686|2567->1727|2596->1728|2674->1778|2703->1779|2790->1838|2819->1839|2862->1854|2891->1855|2947->1875|2972->1891|3011->1892|3068->1921|3097->1922|3138->1935|3167->1936|3275->2016|3304->2017|3361->2046|3390->2047|3770->2399|3799->2400|4156->2729|4185->2730|4258->2775|4287->2776|4372->2833|4401->2834|4479->2884|4508->2885|4651->3000|4680->3001|4827->3120|4856->3121|4901->3138|4930->3139|5009->3190|5038->3191|5124->3249|5153->3250|5248->3317|5277->3318|5311->3324|5340->3325|5485->3442|5514->3443|5559->3460|5588->3461|5673->3518|5702->3519|5814->3603|5843->3604|5928->3661|5957->3662|6131->3808|6160->3809|6365->3985|6395->3986|6472->4034|6502->4035|6684->4188|6714->4189|6749->4195|6779->4196|6961->4349|6991->4350|7033->4363|7063->4364|7138->4410|7168->4411|7247->4461|7277->4462|7365->4521|7395->4522|7439->4537|7469->4538|7536->4576|7566->4577|7646->4628|7676->4629|8134->5058|8164->5059|8802->5668|8832->5669|9160->5968|9190->5969|9238->5988|9268->5989|9374->6066|9404->6067|9459->6093|9489->6094|9540->6116|9570->6117|9614->6132|9644->6133|9711->6171|9741->6172|9893->6295|9923->6296|10307->6651|10337->6652|10885->7171|10915->7172|11021->7249|11051->7250|11114->7284|11144->7285|11204->7316|11234->7317|11328->7382|11358->7383|11463->7459|11493->7460|11718->7656|11748->7657|11876->7756|11906->7757|11966->7788|11996->7789|12051->7815|12081->7816|12139->7845|12169->7846|12222->7870|12252->7871|12299->7889|12329->7890|12415->7947|12445->7948|12490->7964|12520->7965|12604->8020|12634->8021|12810->8168|12840->8169|12925->8225|12955->8226|13002->8244|13032->8245|13114->8298|13144->8299|13188->8314|13218->8315|13297->8365|13327->8366|13498->8508|13528->8509|13613->8565|13643->8566|13690->8584|13720->8585|13802->8638|13832->8639|13876->8654|13906->8655|13983->8703|14013->8704|14183->8845|14213->8846|14358->8962|14388->8963|14435->8981|14465->8982|14547->9035|14577->9036|14621->9051|14651->9052|14720->9092|14750->9093|14913->9227|14943->9228|15204->9460|15234->9461|15281->9479|15311->9480|15393->9533|15423->9534|15638->9720|15668->9721|15716->9736|15769->9752|15795->9768|15835->9769|15893->9798|15923->9799|15965->9812|15995->9813|16104->9893|16134->9894|16188->9919|16218->9920|16559->10232|16589->10233|16931->10546|16961->10547|17035->10592|17065->10593|17147->10646|17177->10647|17256->10697|17286->10698|17422->10805|17452->10806|17588->10913|17618->10914|17664->10931|17694->10932|17774->10983|17804->10984|17887->11038|17917->11039|18001->11094|18031->11095|18066->11101|18096->11102|18222->11199|18252->11200|18298->11217|18328->11218|18414->11275|18444->11276|18553->11356|18583->11357|18673->11418|18703->11419|18878->11565|18908->11566|19099->11728|19129->11729|19206->11777|19236->11778|19410->11923|19440->11924|19475->11930|19505->11931|19679->12076|19709->12077|19755->12094|19785->12095|19865->12146|19895->12147|19978->12201|20008->12202|20104->12269|20134->12270|20182->12289|20212->12290|20282->12331|20312->12332|20387->12378|20417->12379|20542->12475|20572->12476|20620->12495|20650->12496|20733->12550|20763->12551|20837->12596|20867->12597|20916->12613|20958->12626|20988->12627|21347->12949|21363->12955|21406->12975|21728->13260|21772->13294|21812->13295|22510->13960|22965->14378|22981->14384|23031->14411|23505->14848|23549->14882|23589->14883|23656->14913|23671->14918|23714->14938|23773->14964|23836->14990|23862->15006|23902->15007|23969->15037|23984->15042|24026->15061|24085->15087|24301->15266|24343->15298|24383->15299|25070->15953|25173->16019|25203->16026
                    LINES: 19->1|22->1|45->24|45->24|45->24|61->40|61->40|63->42|63->42|64->43|64->43|66->45|66->45|67->46|67->46|70->49|70->49|70->49|71->50|71->50|71->50|71->50|72->51|72->51|73->52|73->52|81->60|81->60|88->67|88->67|90->69|90->69|92->71|92->71|93->72|93->72|95->74|95->74|97->76|97->76|98->77|98->77|99->78|99->78|100->79|100->79|102->81|102->81|102->81|102->81|105->84|105->84|106->85|106->85|107->86|107->86|109->88|109->88|111->90|111->90|114->93|114->93|122->101|122->101|122->101|122->101|125->104|125->104|125->104|125->104|128->107|128->107|129->108|129->108|131->110|131->110|132->111|132->111|134->113|134->113|135->114|135->114|139->118|139->118|141->120|141->120|149->128|149->128|160->139|160->139|166->145|166->145|166->145|166->145|168->147|168->147|169->148|169->148|173->152|173->152|174->153|174->153|176->155|176->155|179->158|179->158|185->164|185->164|194->173|194->173|196->175|196->175|198->177|198->177|199->178|199->178|201->180|201->180|202->181|202->181|205->184|205->184|207->186|207->186|208->187|208->187|210->189|210->189|213->192|213->192|215->194|215->194|215->194|215->194|217->196|217->196|219->198|219->198|221->200|221->200|224->203|224->203|226->205|226->205|226->205|226->205|228->207|228->207|229->208|229->208|231->210|231->210|234->213|234->213|236->215|236->215|236->215|236->215|238->217|238->217|239->218|239->218|240->219|240->219|243->222|243->222|246->225|246->225|246->225|246->225|248->227|248->227|249->228|249->228|251->230|251->230|254->233|254->233|259->238|259->238|259->238|259->238|261->240|261->240|265->244|265->244|267->246|270->249|270->249|270->249|271->250|271->250|271->250|271->250|272->251|272->251|273->252|273->252|281->260|281->260|288->267|288->267|290->269|290->269|292->271|292->271|293->272|293->272|295->274|295->274|297->276|297->276|298->277|298->277|299->278|299->278|300->279|300->279|302->281|302->281|302->281|302->281|305->284|305->284|306->285|306->285|307->286|307->286|309->288|309->288|311->290|311->290|314->293|314->293|322->301|322->301|322->301|322->301|325->304|325->304|325->304|325->304|328->307|328->307|329->308|329->308|332->311|332->311|333->312|333->312|335->314|335->314|336->315|336->315|339->318|339->318|340->319|340->319|343->322|343->322|344->323|344->323|346->325|346->325|348->327|348->327|349->328|350->329|350->329|363->342|363->342|363->342|368->347|368->347|368->347|378->357|383->362|383->362|383->362|391->370|391->370|391->370|392->371|392->371|392->371|393->372|394->373|394->373|394->373|395->374|395->374|395->374|396->375|404->383|404->383|404->383|416->395|418->397|418->397
                    -- GENERATED --
                */
            