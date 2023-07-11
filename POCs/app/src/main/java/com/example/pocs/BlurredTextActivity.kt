package com.example.pocs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BlurredTextActivity : AppCompatActivity() {

    private lateinit var txtView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blurred_text)

        txtView = findViewById(R.id.txt)

        txtView.text = "Rohan".maskText(true)
    }
}