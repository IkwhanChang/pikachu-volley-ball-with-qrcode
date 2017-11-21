@(user: User)(implicit r: RequestHeader)

$(document ).ready(function() {

    var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
    var chatSocket = new WS("@routes.Application.chat(user.token).webSocketURL()")
    //chatSocket.replace("ws:","wss:");

    $.sendMessage = function() {
        chatSocket.send(JSON.stringify(
            {text: $("#talk").val()}
        ))
        $("#talk").val('')
    }

    $.receiveEvent = function(event) {
        var data = JSON.parse(event.data)
        console.log(data)
        // Handle errors
        if(data.Action == "makeRoom" && "@user.token" != data.owner_id){
            var table = $("#tbl_room").DataTable();

            var rowNode = table.row.add([data.seq,
                data.title,
                data.owner,
                data.time,
                "",
                '<button type="button" class="btn btn-primary btn-join-room  btn-sm" id="btn-join-room" data-room-title="'+data.title+'" data-room-no="'+data.seq+'" data-room-seq="'+data.seq+'">Join</button>'
            ]).draw(function() {
                $(".btn-join-room").click(function() {
                    $("#form2 input[name=seq_room]").val($(this).data("roomSeq"));
                    $("#form2").submit();
                });
                $(this).addClass("room_"+data.seq);
            }).nodes()
                .to$()
                .addClass( "room_"+data.seq );

            $(rowNode).addClass("room_"+data.seq);

            $(".btn-join-room").click(function() {
                $("#form2 input[name=seq_room]").val($(this).data("roomSeq"));
                $("#form2").submit();
            });
        }

        if(data.Action == "quitRoom"){
            var roomClass = ".room_"+data.seq;
            $(roomClass).hide();
        }

        if(data.Action == "join"){
            $.setUserStatus(data.seq,"join");
        }

        if(data.Action == "quit"){
            $.setUserStatus(data.seq,"quit");
        }

        if(data.Action == "joinRoom"){
            $.setUserStatus(data.seq,"joinRoom");
        }

    }

    chatSocket.onmessage = function(e) {
        $.receiveEvent(e);
    }
    $.setUserStatus = function(seq,status) {
        var btnId = "#btn_user_"+seq;
        if(status == "join"){
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("btn-warning").val("Waiting");
        }else if(status == "joinRoom"){
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("btn-info").val("Playing");
        }else if(status == "create"){
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("btn-info").val("Playing");
        }else if(status == "quit"){
            $(btnId).removeClass("btn-warning").removeClass("btn-info").removeClass("btn-default").removeClass("disabled").addClass("disabled").addClass("btn-default").val("Offline");
        }
    }

    $("#btn-make-room").click(function() {
        $.ajax(
                jsRoutes.controllers.Room.addRoom(
                    $("#mkroom_title").val(),
                    $("#mkroom_score").val(),
                    "@user.token"
                )
            ).done(function(data){
                console.log(data.seq);
                //location.href="/game?token=@user.token&seq_room="+data.seq
                $("#form2 input[name=seq_room]").val(data.seq);
                $("#form2").submit();

            } ).fail(function(e){
                console.log(e);
            });
    });

    $(".btn-join-room").click(function() {
        $("#form2 input[name=seq_room]").val($(this).data("roomSeq"));
        $("#form2").submit();
    });
});