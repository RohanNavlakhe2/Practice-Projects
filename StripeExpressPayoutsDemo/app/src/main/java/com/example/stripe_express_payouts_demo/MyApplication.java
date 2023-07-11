package com.example.stripe_express_payouts_demo;

import android.app.Application;

import com.stripe.android.PaymentConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PaymentConfiguration.init(getApplicationContext(),"pk_test_51BTUDGJAJfZb9HEBwDg86TN1KNprHjkfipXmEDMb0gSCassK5T3ZfxsAbcgKVmAIXF7oZ6ItlZZbXO6idTHE67IM007EwQ4uN3");
    }
}
