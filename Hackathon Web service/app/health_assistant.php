<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class health_assistant extends Model
{
    public function data_hralth()
    {
        return $this->belongsTo('App\data_hralth');
    }
}
