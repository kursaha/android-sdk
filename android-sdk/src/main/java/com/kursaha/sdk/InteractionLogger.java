package com.kursaha.sdk;

import android.util.Log;

public class InteractionLogger {
    private static final String TAG = "InteractionLogger";

    public interface InteractionListener {
        void onInteraction(String interactionType, String interactionDetails);
    }

    private static InteractionListener listener;

    public static void setListener(InteractionListener interactionListener) {
        listener = interactionListener;
    }

    public static void logInteraction(String interactionType, String interactionDetails) {
        Log.e(TAG, "log interaction: " + interactionType + " " + interactionDetails);

    }
}






