package com.example.pocs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pocs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blurredImageBtn.setOnClickListener {
            val intent = Intent(this,BlurredImageActivity::class.java)
            startActivity(intent)
        }

        binding.blurredViewBtn.setOnClickListener {
            val intent = Intent(this,BlurredViewActivity::class.java)
            startActivity(intent)
        }

        binding.blurredTextBtn.setOnClickListener {
            val intent = Intent(this,BlurredTextActivity::class.java)
            startActivity(intent)
        }

        binding.blurredViewLibBtn.setOnClickListener {
            val intent = Intent(this,BlurredViewLibActivity::class.java)
            startActivity(intent)
        }

        binding.blurredViewBtn2.setOnClickListener {
            val intent = Intent(this,BlurredViewActivity2::class.java)
            startActivity(intent)
        }


    }
}