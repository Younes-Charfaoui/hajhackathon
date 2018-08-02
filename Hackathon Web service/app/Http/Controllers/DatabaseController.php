<?php

namespace App\Http\Controllers;
use App\hajj;
use Illuminate\Http\Request;

class DatabaseController extends Controller
{

	  public function index()
    {
    	$hajjs=hajj::where('name','mouh hajj')->get;
    	dd($hajjs);
    	return view('layouts.database');
    }
}