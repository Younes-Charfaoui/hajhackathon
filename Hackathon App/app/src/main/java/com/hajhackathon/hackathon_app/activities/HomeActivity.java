package com.hajhackathon.hackathon_app.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.hajhackathon.hackathon_app.R;
import com.hajhackathon.hackathon_app.asynck.ResponseAsyncTask;
import com.hajhackathon.hackathon_app.networking.models.RequestPackage;

public class HomeActivity extends AppCompatActivity {

    private Button mHealthSos, mImLost, mContactGuide, mLosts;
    private FusedLocationProviderClient mFusedLocationClient;
    private Location mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 55);
            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            mLocation = location;
                        }
                    }
                });

        mHealthSos = findViewById(R.id.health_sos_button);
        mImLost = findViewById(R.id.im_lost_button);
        mContactGuide = findViewById(R.id.contact_guide_button);
        mLosts = findViewById(R.id.lost_button);

        mHealthSos.setOnClickListener(v -> {
            Toast.makeText(this, "Message is sending to nearest health care assistant", Toast.LENGTH_SHORT).show();
            // TODO: 02-Aug-18 send message informing a health problem to web service

            RequestPackage request = new RequestPackage.Builder()
                    .addMethod(RequestPackage.POST)
//                    .addEndPoint()
//                    .addParams()
//                    .addParams()
//                    .addParams()
                    .create();
            ResponseAsyncTask task = new ResponseAsyncTask(response -> {
                // waiting for the response
            });

            task.execute();
        });

        mImLost.setOnClickListener(v -> {
            Toast.makeText(this, "Message is sending to nearest assistant", Toast.LENGTH_SHORT).show();
            // TODO: 02-Aug-18 send message informing a lost to web service

            RequestPackage request = new RequestPackage.Builder()
                    .addMethod(RequestPackage.POST)
//                    .addEndPoint()
//                    .addParams()
//                    .addParams()
//                    .addParams()
                    .create();
            ResponseAsyncTask task = new ResponseAsyncTask(response -> {
                // waiting for the response
            });

            task.execute();
        });

        mContactGuide.setOnClickListener(v -> {
            startActivity(new Intent(this, ChatActivity.class));
        });

        mLosts.setOnClickListener(v -> {
            startActivity(new Intent(this, ThingLosesActivity.class));
        });
    }
}
