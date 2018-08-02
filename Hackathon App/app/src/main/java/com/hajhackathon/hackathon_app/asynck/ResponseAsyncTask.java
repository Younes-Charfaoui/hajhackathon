/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.hajhackathon.hackathon_app.asynck;

import android.os.AsyncTask;
import android.util.Log;

import com.hajhackathon.hackathon_app.networking.models.RequestPackage;
import com.hajhackathon.hackathon_app.networking.models.Response;
import com.hajhackathon.hackathon_app.networking.utilities.HttpUtilities;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class ResponseAsyncTask extends AsyncTask<RequestPackage, Void, Response> {

    private ResponseTaskListener mTaskListener;

    public ResponseAsyncTask(ResponseTaskListener listener) {
        this.mTaskListener = listener;
    }

    @Override
    protected void onPostExecute(Response loginResponse) {
        mTaskListener.OnComplete(loginResponse);
    }

    @Override
    protected Response doInBackground(RequestPackage... requestPackages) {

        try {
            String response = HttpUtilities.getData(requestPackages[0]);
            Log.i("Zbo", "doInBackground: " + response);
            try {
                JSONObject object = new JSONObject(response);
                int status = object.getInt("status");
                return new Response(status);
            } catch (JSONException e) {
                return null;
            }

        } catch (IOException e) {
            return null;
        }

    }

    public interface ResponseTaskListener {
        void OnComplete(Response response);
    }
}