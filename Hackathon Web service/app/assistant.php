<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class assistant extends Model
{
    public function comunication()
    {
        return $this->belongsTo('App\comunication');
    }
}
