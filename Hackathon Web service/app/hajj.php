<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class hajj extends Model
{
    	protected $guarded = [] ;

       

       public function comunication()
       {
           return $this->belongsTo('App\comunication');
       }

       public function data_health()
       {
           return $this->belongsTo('App\data_health');
       }

	    public function notification()
	       {
	           return $this->belongsTo('App\notification');
	       }
	       
	       public function md_file()
	       {
	           return $this->belongsTo('App\md_file');
	       }

}
