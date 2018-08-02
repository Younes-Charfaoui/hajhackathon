<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class maladie extends Model
{
    public function md_file()
    {
        return $this->belongsTo('App\md_file');
    }

   

}
