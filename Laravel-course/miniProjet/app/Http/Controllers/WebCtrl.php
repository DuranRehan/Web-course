<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class WebCtrl extends Controller
{
    function index()
    {
        return view('index');
    }
    function displayChannelMsg(Request $request)
    {
        $channel = $request->get('channels');
        $arr = array(
            'username' => $request->get('username'),
            'channel' => $request->get('channel')
        );
        $json = json_encode($arr);
        return view('tchat', compact('json'));
    }
}
