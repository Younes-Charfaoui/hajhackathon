package com.hajhackathon.hackathon_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hajhackathon.hackathon_app.R;

public class ValidationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);


        findViewById(R.id.alright_button).setOnClickListener(v -> {

            // send to the home activity
            startActivity(new Intent(this, HomeActivity.class));
        });

        findViewById(R.id.problem_button).setOnClickListener(v -> {

        });
    }
}
