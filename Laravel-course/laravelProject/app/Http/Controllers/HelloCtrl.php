<?php

namespace App\Http\Controllers;

class HelloCtrl extends Controller
{
    public function index($name)
    {
        return view('hello',['name'=>$name]);
    }
}
