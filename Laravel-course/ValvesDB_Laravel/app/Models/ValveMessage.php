<?php   
    namespace App\Models;
    class ValveMessage{
        static function findAll(){
            $messages= \DB::select("SELECT Message.msg_date, Author.name, Message.title,Message.id
            FROM Message
            JOIN Author ON Message.author = Author.id
            ORDER BY msg_date DESC");
            return $messages;
        }
        static function getDetail($id) {
            $details= \DB::select("SELECT id,msg_date,title,content from message where id =$id");
            return $details;
        }
    }
?>