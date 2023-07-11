package com.example.saurabhfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity:AppCompatActivity(){

    private lateinit var editText:EditText
    private lateinit var textView:TextView
    private lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_10)

        editText = findViewById(R.id.edittext)
        textView = findViewById(R.id.nameTxt)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {

            textView.text = editText.text

            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra(Constants.NAME,editText.text.toString())
            startActivity(intent)
        }

        editText.doAfterTextChanged {
            textView.text = it
        }
    }
}