<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ApiModel;

class ApiController extends Controller
{
    function getAll()
    {
        $channels = ApiModel::getAll();
        return response()->json($channels);
    }
    function getChannelMessages($chatRoomId)
    {
        $messages = ApiModel::getChannelMessage($chatRoomId);
        return response()->json($messages);
    }
    function insertChannelMessage(Request $request, $chatRoomId)
    {
        $login = $request->post("login");
        $content = $request->post("content");
        $result =  ApiModel::insertChannelMessage($chatRoomId, $login, $content);
        return response()->json($result);
    }
    function createAccount(Request $request)
    {
        $login = $request->post("login");
        $displayName = $request->post("displayName");
        $result = ApiModel::createUser($login,$displayName);
        return response()->json($result);
    }
}
