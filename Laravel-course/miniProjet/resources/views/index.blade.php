@extends('canvas')
@section('title','Login')
@section('content')
<form name="form1" action="./tchat" method="get">
    <div>
        <label for="name">Username:</label>
        <input type="text" id="username-input" name="username">
    </div>
    <div>
        <label for="channel-select">Choose a channel:</label>
        <select name="channel" id="channel-select">
            <script>
                $.getJSON(`/api/channels`, function(data, status) {
                    data.forEach(channel => {
                        $("#channel-select").append(`<option value=${channel.id}>${channel.name}</option>`);
                    });
                })
            </script>
        </select>
    </div>
    <button>Tchat!</button>
</form>

<h2>Register section </h2>
    <div>
        <label for="login-input">Login :</label>
        <input type="text" id="login-input" name="loginInput">
    </div>

    <div>
        <label for="displayName-input">Display name :</label>
        <input type="text" id="displayName-input" name="DisplayNameInput">
    </div>
    <button id="registerBtn">Register</button>

<script>
    function onRegister() {
        let loginUser=$("#login-input").val();
        let displayNameUser= $("#displayName-input").val();
        $.post("/api/account/create", {
                login: loginUser,
                displayName: displayNameUser
            },
            function(data, status) {
                if(data){
                    $("body").append(`<div>Account Succeffuly created </div>`)
                } else {
                    $("body").append(`<div>Error during the account creation !</div>`)
                }
            });
    }
    $(document).ready(function() {
        $("#registerBtn").click(function() {
            onRegister();
        });
    });
</script>
@endsection