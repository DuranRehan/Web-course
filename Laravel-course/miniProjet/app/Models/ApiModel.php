<?php

namespace App\Models;

use Illuminate\Support\Facades\DB;

class ApiModel
{
    static public function getAll()
    {
        $channels = DB::select('select * from channels');
        return $channels;
    }

    static public function getChannelMessage($chatRoomId)
    {
        $messages = DB::select("SELECT * FROM messages JOIN chatusers ON chatusers.id=messages.author_id WHERE chan_id= ? order by messages.added_on", [$chatRoomId]);
        return $messages;
    }

    static public function insertChannelMessage($chatRoomId, $login, $content)
    {
        $authorId = DB::select("SELECT id FROM `chatusers` WHERE login=?", [$login]);
        if ($authorId != null) {
            $id = $authorId[0]->id;
            $date = date("Y-m-d H:i:s");
            $result = DB::insert("INSERT INTO `messages`(added_on,content,author_id,chan_id) VALUES(?,?,?,?)", [$date, $content, $id, $chatRoomId]);
            return $result;
        }
        return false;
    }

    static public function createUser($login, $displayName)
    {
        $result = DB::insert("INSERT INTO `chatusers`(login,displayName) VALUES(?,?)", [$login, $displayName]);
        return $result;
    }
}
