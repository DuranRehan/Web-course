@extends('canvas')
@section('title', 'détails')

@section('content')
<table class='messages'>
    <tr><th>Date</th><th>Titre</th><th>Message</th></tr>
@foreach($details as $detail)
    <tr>
        <td>{{$detail->msg_date}}</td>
        <td>{{$detail->title}}</td>
        <td>{{$detail->content}}</td>
    </tr>
@endforeach
@endsection