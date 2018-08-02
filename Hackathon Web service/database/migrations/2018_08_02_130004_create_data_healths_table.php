<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateDataHealthsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('data_healths', function (Blueprint $table) {
            $table->increments('id_data_health');
            $table->string('hajj_id');
            $table->string('assinstants_id');
            $table->string('hajj_problem');
            $table->string('assistant_comment');
            $table->date('dateOfProblme');
            $table->integer('thereIsProblm');
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
        Schema::dropIfExists('data_healths');
    }
}
