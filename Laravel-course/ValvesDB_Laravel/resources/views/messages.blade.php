@extends('canvas')
@section('title', 'All messages')

@section('content')
<table>
    <tr><th>Date</th><th>Auteur</th><th>Titre</th></tr>
    @foreach($messages as $message)
    <tr>
        <td>{{$message->msg_date}}</td>
        <td>{{$message->name}}</td>
        <td><a id="content" href="./{{$message->id}}">{{$message->title}}</a></td>
    </tr>
    @endforeach
</table>
@endsection