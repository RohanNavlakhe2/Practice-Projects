package com.example.pocs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pocs.databinding.ActivityBlurredView2Binding

class BlurredViewActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityBlurredView2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlurredView2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blurBtn.setOnClickListener {
            //makeViewBlurred()
            val blurDrawable = BlurDrawable(binding.viewToBlur,30)
            binding.viewToBlur.foreground = blurDrawable

            val blurDrawable2 = BlurDrawable(binding.marginView,30)
            binding.marginView.foreground = blurDrawable2
        }
    }
}