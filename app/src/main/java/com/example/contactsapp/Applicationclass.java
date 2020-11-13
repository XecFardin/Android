package com.example.contactsapp;

import android.app.Application;

import com.backendless.Backendless;

public class Applicationclass  extends Application {

    public static final String APPLICATION_ID = "79BDCFF6-1E26-9DD0-FF67-5CD522CCEF00";
    public static final String API_KEY = "44D68DEE-F3AE-4708-B68A-14BFC2EA3880";
    public static final String SERVER_URL = "http://api.backendless.com";


    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}
