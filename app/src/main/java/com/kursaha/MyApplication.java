package com.kursaha;

import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Kursaha SDK
        // Please do not use this in Production
        Kursaha.initialize(this, "<API-KEY>");
        Kursaha.sendCustomerDetails("1234", "sample@kursaha.com");
    }
}
