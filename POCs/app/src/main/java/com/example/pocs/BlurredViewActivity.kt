package com.example.pocs

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.pocs.databinding.ActivityBlurredViewBinding

class BlurredViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBlurredViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlurredViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blurBtn.setOnClickListener {
            //makeViewBlurred()
            val blurDrawable = BlurDrawable(binding.viewToBlur,30)
            //binding.blurOverlay.background = blurDrawable;
            //binding.blurOverlay.foreground = blurDrawable
            //binding.viewToBlur.background = ContextCompat.getDrawable(this,R.drawable.blur_background_border)
            binding.viewToBlur.foreground = blurDrawable
        }
    }

   /* fun makeViewBlurred() {

        val bitmap = Bitmap.createBitmap(binding.viewToBlur.width,binding.viewToBlur.height,
            Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        binding.viewToBlur.draw(canvas)

        //binding.blurredView.setImageBitmap(bitmap)

        //val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.i)
        val blurredBitmap = BlurBuilder.blur(this,bitmap)
        //binding.blurredView.background = BitmapDrawable(resources, blurredBitmap)
        binding.blurredView.setImageBitmap(blurredBitmap)


    }*/
}