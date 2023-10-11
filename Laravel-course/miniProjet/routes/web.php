<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\WebCtrl;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', [WebCtrl::class,'index']);
Route::get('/index',[WebCtrl::class,'index']);
Route::get('/tchat',[WebCtrl::class,'displayChannelMsg']);