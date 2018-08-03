package com.hajhackathon.hackathon_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hajhackathon.hackathon_app.PreferencesManager;
import com.hajhackathon.hackathon_app.R;
import com.hajhackathon.hackathon_app.asynck.ResponseAsyncTask;
import com.hajhackathon.hackathon_app.networking.models.RequestPackage;
import com.hajhackathon.hackathon_app.networking.utilities.NetworkUtilities;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sign_in_button).setOnClickListener(v -> {

            if (NetworkUtilities.isConnected(this)) {

                findViewById(R.id.sign_in_button).setVisibility(View.GONE);
                findViewById(R.id.login_progress).setVisibility(View.VISIBLE);

                String name = ((TextInputEditText) findViewById(R.id.name_text_edit)).getText().toString();
                String passport = ((TextInputEditText) findViewById(R.id.passport_text_edit)).getText().toString();

                RequestPackage request = new RequestPackage.Builder()
                        .addEndPoint("http://192.168.137.1/DZ_dreamSquad/public/auth")
                        .addParams("name", name)
                        .addParams("passport", passport)
                        .addParams("type", String.valueOf(getCategory()))
                        .addMethod(RequestPackage.POST)
                        .create();

                ResponseAsyncTask responseAsyncTask = new ResponseAsyncTask(response -> {
                    if (response.getStatus() == 200) {
                        Intent intent = null;
                        switch (getCategory()) {
                            case 1:
                                intent = new Intent(this, ValidationActivity.class);
                                break;
                            case 2:
                                intent = new Intent(this, HealthActivity.class);
                                break;
                            case 3:
                                intent = new Intent(this, AssistantActivity.class);
                                break;
                            case 4:
                                intent = new Intent(this, MorchidActivity.class);
                                break;
                        }
                        startActivity(intent);
                        new PreferencesManager(this).setLoginHaj(passport, name, getCategory());
                        finish();
                    } else {
                        findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
                        findViewById(R.id.login_progress).setVisibility(View.GONE);
                    }
                });
                responseAsyncTask.execute(request);
            } else {
                Toast.makeText(this, "No internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getCategory() {
        int idRadio = ((RadioGroup) findViewById(R.id.category_group)).getCheckedRadioButtonId();

        switch (idRadio) {
            case R.id.category_daya3:
                idRadio = 3;
                break;
            case R.id.category_haj:
                idRadio = 1;
                break;
            case R.id.category_health:
                idRadio = 2;
                break;
            case R.id.category_morchid:
                idRadio = 4;
                break;
            default:
                idRadio = 0;
        }

        return idRadio;
    }
}
