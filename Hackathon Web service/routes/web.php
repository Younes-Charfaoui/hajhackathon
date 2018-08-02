<?php

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

Route::get('/', function () {
    return view('welcome');
});

Auth::routes();
//mouh creyi ga3 projet jdid bach teviter thaws et tt saha
// Route::get('/database', function () {
//     return view('database')->name('database');
// });

Route::get('/home', 'HomeController@index')->name('home');
Route::get('/database', 'DatabaseController@index')->name('database');
