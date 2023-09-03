package com.kursaha.sdk;

import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.kursaha.KursahaClient;

public class KursahaActivity extends AppCompatActivity {

    private final KursahaClient kursahaClient;

    public KursahaActivity() {
        kursahaClient = new KursahaClient("<get api key from the server>");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InteractionLogger.logInteraction(ev.toString(), "Touch event");
        // send signal here
        return super.dispatchTouchEvent(ev);
    }
}
