package com.kursaha;

import android.app.Application;
import com.kursaha.engagedatadrive.dto.CustomerData;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Kursaha SDK
        // Please do not use this in Production
        Kursaha.initialize(this, "<API-KEY>");

        CustomerData customerData = new CustomerData();
        customerData.setEmail("<customer-email>");
        Kursaha.sendCustomerDetails("<customer-id>", customerData);
    }
}
