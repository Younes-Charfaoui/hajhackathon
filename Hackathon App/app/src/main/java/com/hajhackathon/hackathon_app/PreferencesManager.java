/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.hajhackathon.hackathon_app;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @definition: this class is responsible for creating and managing the
 * shared preferences files in the android phone.
 * <p>
 * We are storing some basic information of the user like :ID, name and so
 * on , also is user is login.
 */

public class PreferencesManager {

    private static final String TAG = "manager";
    private static final int PRIVATE_MODE = 0;
    private static final String PREFERENCE_CONFIGURATION_NAME = "configuration";

    private static final String FIRST_TIME = "isFirstTime";
    private static final String LOGIN = "login";
    private static final String FULL_NAME = "fullName";
    private static final String PASSPORT = "passport";
    private static final String TYPE = "type";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @SuppressLint("CommitPrefEdits")
    public PreferencesManager(Context mContext) {
        mPreferences = mContext.getSharedPreferences(PREFERENCE_CONFIGURATION_NAME, PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }


    public boolean isLogin() {
        return mPreferences.getBoolean(LOGIN, false);
    }

    public void setLoginHaj(String passport, String fullName, int type) {
        mEditor.putString(FULL_NAME, fullName);
        mEditor.putInt(TYPE, type);
        mEditor.putBoolean(LOGIN, true);
        mEditor.putString(PASSPORT, passport);
        mEditor.apply();
    }

    void removePreference() {
        mEditor.clear().commit();
    }
}
