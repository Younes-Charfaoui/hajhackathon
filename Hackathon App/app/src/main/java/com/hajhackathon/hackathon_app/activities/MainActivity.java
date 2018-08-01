package com.hajhackathon.hackathon_app.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.hajhackathon.hackathon_app.R;
import com.hajhackathon.hackathon_app.asynck.ResponseAsyncTask;
import com.hajhackathon.hackathon_app.networking.models.RequestPackage;
import com.hajhackathon.hackathon_app.networking.models.Response;

public class MainActivity extends AppCompatActivity implements ResponseAsyncTask.ResponseTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sign_in_button).setOnClickListener(v -> {

            String name = ((TextInputEditText) findViewById(R.id.name_text_edit)).getText().toString();
            String passport = ((TextInputEditText) findViewById(R.id.passport_text_edit)).getText().toString();

            RequestPackage request = new RequestPackage.Builder()
//                    .addEndPoint()
                    .addParams("name", name)
                    .addParams("passport", passport)
                    .addParams("type", String.valueOf(getCategory()))
                    .addMethod(RequestPackage.POST)
                    .create();

            ResponseAsyncTask responseAsyncTask = new ResponseAsyncTask(this);
            responseAsyncTask.execute(request);
        });
    }

    @Override
    public void OnComplete(Response response) {
        // check the information and send to new activity
        Intent intent = new Intent(this, ValidationActivity.class);
        intent.putExtra("type", getCategory());
        startActivity(intent);
    }

    public int getCategory() {
        int idRadio = ((RadioGroup) findViewById(R.id.category_group)).getCheckedRadioButtonId();

        switch (idRadio) {
            case R.id.category_daya3:
                idRadio = 2;
                break;
            case R.id.category_haj:
                idRadio = 1;
                break;
            case R.id.category_health:
                idRadio = 3;
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
