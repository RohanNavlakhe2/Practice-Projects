package com.example.stripe_express_payouts_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.os.Bundle;

import com.stripe.android.Stripe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initStripe(){

    }
}