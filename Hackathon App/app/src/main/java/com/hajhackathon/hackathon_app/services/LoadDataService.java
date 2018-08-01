
package com.hajhackathon.hackathon_app.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Display;


import com.hajhackathon.hackathon_app.networking.models.RequestPackage;
import com.hajhackathon.hackathon_app.networking.utilities.HttpUtilities;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @definition this service will basically do the network operation
 * to get the data from the server and broadcast it to
 * specific activity or fragment that are waiting for it.
 */

public class LoadDataService extends IntentService {


    private static final String KEY_ACTION = "action";
    private static final String KEY_REQUEST = "constant";

    public LoadDataService() {
        super("LoadDataService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        int type = intent.getIntExtra(KEY_ACTION, -1);
        RequestPackage request = intent.getParcelableExtra(KEY_REQUEST);

    }

//    private void displayCallProfessor(RequestPackage request) {
//        try {
//            String response = HttpUtilities.getData(request);
//            ArrayList<Display> displayList = JsonUtilities.getDisplaysListProfessor(response);
//            Intent intent = new Intent(DISPLAY_ACTION);
//            intent.putExtra(KEY_DATA, displayList);
//            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


}
