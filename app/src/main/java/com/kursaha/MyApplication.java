package com.kursaha;

import android.app.Application;

import com.kursaha.sdk.InteractionLogger;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        InteractionLogger.setListener(new InteractionLogger.InteractionListener() {
            @Override
            public void onInteraction(String interactionType, String interactionDetails) {

            }
        });
    }
}
