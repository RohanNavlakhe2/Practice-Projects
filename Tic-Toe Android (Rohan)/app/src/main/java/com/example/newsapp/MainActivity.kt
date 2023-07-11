package com.example.newsapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var myTurn = true
    private var rohansMoves = ArrayList<Int>()
    private var cpuMoves = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        activityMainBinding.box1.setOnClickListener(this)
        activityMainBinding.box2.setOnClickListener(this)
        activityMainBinding.box3.setOnClickListener(this)
        activityMainBinding.box4.setOnClickListener(this)
        activityMainBinding.box5.setOnClickListener(this)
        activityMainBinding.box6.setOnClickListener(this)
        activityMainBinding.box7.setOnClickListener(this)
        activityMainBinding.box8.setOnClickListener(this)
        activityMainBinding.box9.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
         when(v?.id){
             R.id.box1 -> {
                checkBox(1)
             }
             R.id.box2 -> {
                 checkBox(2)
             }
             R.id.box3 -> {
                 checkBox(3)
             }
             R.id.box4 -> {
                 checkBox(4)
             }
             R.id.box5 -> {
                 checkBox(5)
             }
             R.id.box6 -> {
                 checkBox(6)
             }
             R.id.box7 -> {
                 checkBox(7)
             }
             R.id.box8 -> {
                 checkBox(8)
             }
             R.id.box9 -> {
                 checkBox(9)
             }
         }
    }

    private fun checkBox(boxNumber:Int){
        if(myTurn){
            activityMainBinding.box1.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))
            rohansMoves.add(boxNumber)
            myTurn = false
            cpuMove(boxNumber)
        }else{
            activityMainBinding.box1.setBackgroundColor(resources.getColor(R.color.cardview_dark_background))
            cpuMoves.add(boxNumber)
            myTurn = true
        }
    }

    private fun cpuMove(rohansMove:Int){
        val cpusBox = if(rohansMove!=9) rohansMove+1 else 1
        when(cpusBox){
            1 -> activityMainBinding.box1.performClick()
            2 -> activityMainBinding.box2.performClick()
            3 -> activityMainBinding.box3.performClick()
            4 -> activityMainBinding.box4.performClick()
            5 -> activityMainBinding.box5.performClick()
            6 -> activityMainBinding.box6.performClick()
            7 -> activityMainBinding.box7.performClick()
            8 -> activityMainBinding.box8.performClick()
            9 -> activityMainBinding.box9.performClick()
        }
    }


}