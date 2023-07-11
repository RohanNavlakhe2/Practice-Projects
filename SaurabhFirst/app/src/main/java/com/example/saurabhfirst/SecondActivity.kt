package com.example.saurabhfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var nameTxtView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nameTxtView = findViewById(R.id.nameTxt)

        val name = intent.getStringExtra(Constants.NAME)

        nameTxtView.text = name

        val km = Converter.convertMeterToKm(25f.toDouble())
    }
}