package com.hajhackathon.hackathon_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hajhackathon.hackathon_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sign_in_button).setOnClickListener(v -> {
            // check the information and send to new activity
            startActivity(new Intent(this, ValidationActivity.class));
        });
    }
}
