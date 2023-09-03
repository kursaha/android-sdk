package com.kursaha.listener;

import android.view.View;

import com.kursaha.KursahaClient;

public abstract class OnClickListener implements View.OnClickListener {

    private final KursahaClient kursahaClient;

    protected OnClickListener(KursahaClient kursahaClient) {
        this.kursahaClient = kursahaClient;
    }

    @Override
    public void onClick(View v) {

    }
}
