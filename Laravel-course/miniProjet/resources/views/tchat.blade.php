@extends('canvas')
@section('title','Tchating')
@section('content')

<body>
    <div id="messages"></div>
    <script>
        function displayAllMessages() {
            $("#messages").empty();
            $("#user-content-input").val('');
            $.getJSON(`/api/channels/{{json_decode($json)->channel}}/messages`, function(data, status) {
                data.forEach(message => {
                    $("#messages").append(`<p><span class='username'>${message.displayName}</span> : ${message.content}</p>`);
                });
            })
        }

        function onSendClick() {
            $.post("/api/channels/{{json_decode($json)->channel}}/messages", {
                    login: "{{json_decode($json)->username}}",
                    content: $("#user-content-input").val()
                },
                function(data, status) {
                    if (data) {
                        $(".error").remove();
                        displayAllMessages();
                    } else {
                        $(".error").remove();
                        $("body").append(`<div class="error">Error retry later</div>`)
                    }
                })
        }
        $(document).ready(function() {
            displayAllMessages();
            $("body").append(`<input type="text" id="user-content-input" name="content"><button type="submit" id="sendBtn">Send in tchat</button>`);
            $("body").append(
                $("<button id='refresh'>Refresh</button>").click(function() {
                    displayAllMessages();
                })
            );
            $("#sendBtn").click(function() {
                onSendClick();
            });
        });
    </script>
</body>
@endsection