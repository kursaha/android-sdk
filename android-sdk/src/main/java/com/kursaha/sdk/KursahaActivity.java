package com.kursaha.sdk;

import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class KursahaActivity extends AppCompatActivity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InteractionLogger.logInteraction(ev.toString(), "Touch event");
        // send signal here
        return super.dispatchTouchEvent(ev);
    }
}
