@extends('canvas')
@section('title', 'TODO')
@section('content')
<ul id="liste">
    @foreach($todos as $tache)
    <li>
    <a href="./todos/{{$tache->id}}">{{$tache->name}}</a>
    </li>
    @endforeach
</ul>
<br>
    <form action="./todos" method="post">
        @csrf
        <label for="input_name">name : </label>
        <input type="text" name="input_name"required>
        <br>
        <label for="input_desc">description : </label>

        <input type="text" name="input_desc"required>
        <br>
        <button type="submit">add</button>
    </form>
@endsection