package com.kursaha;

import android.app.Application;

import com.kursaha.sdk.InteractionLogger;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Kursaha SDK
        Kursaha.initialize(this, "YOUR_API_KEY");
        InteractionLogger.setListener(new InteractionLogger.InteractionListener() {
            @Override
            public void onInteraction(String interactionType, String interactionDetails) {

            }
        });
    }
}
