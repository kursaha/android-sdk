package com.kursaha;

import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Kursaha SDK
        Kursaha.initialize(this, "eyJ1aWQiOiIwMHU5bXl2NG9sbkZ2OGJMYzVkNyIsImFsZyI6IkhTNTEyIn0.eyJzdWIiOiI5NmFjMThlZC04OGQ2LTRmNTMtOWJkYi0zMTRmMDFjMTBlMjUiLCJhdXRoIjoiUk9MRV9BUElfVVNFUiIsImV4cCI6MjAwNTg4ODgxN30.9SdxNfOdVIYnBskbTIDxzmVXe1C5WIPR9X8GfuAxBdaHZtWe4bwHTkCTwqZSCTJUKK3NA19A9MhVl4p4sAy2Ng");
        Kursaha.sendCustomerDetails("1234", "sample@kursaha.com");
    }
}
