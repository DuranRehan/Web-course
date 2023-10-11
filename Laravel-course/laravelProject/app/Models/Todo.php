<?php
namespace App\Models;
class Todo{
    static public function findAll() {
        $todos = \DB::select('select * from todos');
        return $todos;
    }

    static public function getDetail($id){
        $desc = \DB::select("SELECT description FROM todos WHERE ID = $id");
        return  $desc[0];    
    }
    static public function insertTodo($name,$desc){
        var_dump($name);
        var_dump($desc);
        \DB::insert("INSERT INTO todos(name,description) values('$name','$desc')");
    }
}