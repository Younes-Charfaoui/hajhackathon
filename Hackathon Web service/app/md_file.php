<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class md_file extends Model
{
    	protected $guarded = [] ;

       public function maladie()
       {
           return $this->hasOne('App\maladie');
       }

       public function hajj()
       {
           return $this->hasOne('App\hajj');
       }

}
