<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Todo;
class TodoController extends Controller
{
    function index(){
        $todos= Todo::findAll();
        return view('todo',compact("todos"));
    }
    function getDetail($id){
        $todos = Todo::getDetail($id);
        
        return view('todo_detail',compact("todos"));
    }
    function addTodo(Request $request){
        Todo::insertTodo($request->post("input_name"),$request->post("input_desc"));
        $todos= Todo::findAll();
        return view('todo',compact("todos"));
    }
}
