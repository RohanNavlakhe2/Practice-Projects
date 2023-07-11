package com.example.pocs

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pocs.databinding.ActivityBlurredImageBinding


class BlurredImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlurredImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlurredImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blurBtn.setOnClickListener {
            makeViewBlurred()
        }
    }

    fun makeViewBlurred() {
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.i)
        val blurredBitmap = BlurBuilder.blur(this, originalBitmap)
        //binding.blurredImageView.background = BitmapDrawable(resources, blurredBitmap)
        binding.blurredImageView.setImageBitmap(blurredBitmap)
    }
}