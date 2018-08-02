<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateHajjsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('hajjs', function (Blueprint $table) {
            $table->increments('id_hajj');
            $table->string('first_name');
            $table->string('laste_name');
            $table->string('nationality');
            $table->string('num_pasport');
            $table->string('yearOfHajj');
            $table->string('number_phone');
            $table->string('id_md_file');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('hajjs');
    }
}
