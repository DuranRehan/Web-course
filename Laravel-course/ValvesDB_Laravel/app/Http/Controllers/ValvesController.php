<?php

namespace App\Http\Controllers;
use App\Http\Controllers\Controller;
use App\Models\ValveMessage;

class ValvesController extends Controller {
    function index(){
        $messages = ValveMessage::findAll();
        return view('messages',compact('messages'));
    }
    function getDetail($id){
        $details = ValveMessage::getDetail($id);
        return view('message_details',compact('details'));
    }
}