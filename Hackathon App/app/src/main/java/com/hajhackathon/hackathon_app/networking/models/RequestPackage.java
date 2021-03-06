/*------------------------------------------------------------------------------
 - Copyright (c) 2018. This code was created by Younes Charfaoui in the process of Graduation Project for the year of  2018 , which is about creating a platform  for students and professors to help them in the communication and the get known of the university information and so on.
 -----------------------------------------------------------------------------*/

package com.hajhackathon.hackathon_app.networking.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;


public class RequestPackage implements Parcelable {

    public static final Parcelable.Creator<RequestPackage> CREATOR = new Parcelable.Creator<RequestPackage>() {
        @Override
        public RequestPackage createFromParcel(Parcel source) {
            return new RequestPackage(source);
        }

        @Override
        public RequestPackage[] newArray(int size) {
            return new RequestPackage[size];
        }
    };
    //public constant we need in the process of making http calls
    public static final String GET = "GET";
    public static final String POST = "POST";

    private String mEndPoint;
    private String mMethod;
    private Map<String, String> mParams;

    public RequestPackage() {
        mParams = new HashMap<>();
    }

    protected RequestPackage(Parcel in) {
        this.mEndPoint = in.readString();
        this.mMethod = in.readString();
        int mParamsSize = in.readInt();
        this.mParams = new HashMap<>(mParamsSize);
        for (int i = 0; i < mParamsSize; i++) {
            String key = in.readString();
            String value = in.readString();
            this.mParams.put(key, value);
        }
    }

    private RequestPackage(String mEndPoint, String mMethod, Map<String, String> mParams) {
        this.mEndPoint = mEndPoint;
        this.mMethod = mMethod;
        this.mParams = mParams;
    }

    public String getEndPoint() {
        return mEndPoint;
    }

    public String getMethod() {
        return mMethod;
    }

    public Map<String, String> getParams() {
        return mParams;
    }

    //this addMethod only add key value pair to the map.
    public void addParams(String key, String value) {
        mParams.put(key, value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mEndPoint);
        dest.writeString(this.mMethod);
        dest.writeInt(this.mParams.size());
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    public static class Builder {
        private String endPoint, method;
        private Map<String, String> params;

        public Builder() {
            this.params = new HashMap<>();
            params.put("", "");
        }

        public Builder addEndPoint(String endPoint) {
            this.endPoint = endPoint;
            return this;
        }

        public Builder addMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder addParams(String key, String value) {
            params.put(key, value);
            return this;
        }

        public RequestPackage create() {
            return new RequestPackage(endPoint, method, params);
        }
    }
}
