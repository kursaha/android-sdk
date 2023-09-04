package com.kursaha;

import android.annotation.SuppressLint;
import android.app.Application;
import android.provider.Settings;
import android.util.Log;

import java.util.UUID;

public class Kursaha {
    private static final String TAG = "Kursaha";

    private final String apiKey;
    private final UUID sessionId;
    private final String deviceId;

    private final KursahaClient kursahaClient;


    public Kursaha(String apiKey, UUID sessionId, String deviceId) {
        this.apiKey = apiKey;
        this.sessionId = sessionId;
        this.deviceId = deviceId;
        this.kursahaClient = new KursahaClient(apiKey);
    }

    public static Kursaha getInstance() {
        if (kursaha == null) {
            throw new RuntimeException("Please call Kursaha.initialize method first");
        }
        return kursaha;
    }

    private static Kursaha kursaha;

    public static void initialize(Application applicationContext, String apiKey, String deviceId) {
        if (kursaha != null) {
            throw new RuntimeException("Kursaha.initialize should be called once");
        }
        UUID sessionId = UUID.randomUUID();
        kursaha = new Kursaha(apiKey, sessionId, deviceId);
    }


    public static void initialize(Application applicationContext, String apiKey) {
        @SuppressLint("HardwareIds") String deviceId =
                Settings.Secure.getString(applicationContext.getContentResolver(), Settings.Secure.ANDROID_ID);

        initialize(applicationContext, apiKey, deviceId);
    }

    public static void initialize(Application applicationContext) {
        //For String values
        @SuppressLint("DiscouragedApi") int apiKeyId =
                applicationContext
                        .getResources()
                        .getIdentifier("kursaha_api_key", "string", applicationContext.getPackageName());
        if (apiKeyId == 0) {
            throw new RuntimeException("Api key is not configured");
        }
        String apiKey = applicationContext.getResources().getString(apiKeyId);
        initialize(applicationContext, apiKey);
    }

    public static void trackEvent(String eventType) {
        if (kursaha == null) {
            Log.d(TAG, "Kursaha is not initialised");
        }
        // send event to server
    }

    public static void updateCustomer() {

    }
}
