package com.kursaha;

import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Kursaha SDK
        Kursaha.initialize(this, "YOUR_API_KEY");
        Kursaha.sendCustomerDetails("1234", "sample@kursaha.com");
    }
}
