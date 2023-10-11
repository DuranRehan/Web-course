<?php

namespace App\Http\Controllers;

use App\Models\Task;

class RestTasksController extends Controller
{
    function tasks($id = null)
    {
        if ($id == null) {
            $result = Task::all();
        } else {
            $result = Task::get($id);
        }
        return json_encode($result);//response()->json($result); // ou json_encode($result)
    }
}
