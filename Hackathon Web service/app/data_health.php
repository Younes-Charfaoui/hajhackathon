<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class data_health extends Model
{
    	protected $guarded = [] ;

        public function hajj()
        {
        	 return $this->hasOne(hajj::class);
        }

        public function health_assistant()
        {
        	 return $this->hasOne(health_assistant::class);
        }

}