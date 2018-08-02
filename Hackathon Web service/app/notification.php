<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class notification extends Model
{
    	protected $guarded = [] ;

        public function hajj()
        {
        	 return $this->hasOne(hajj::class);
        }

        public function assistant()
        {
        	 return $this->hasOne(assistant::class);
        }

}
