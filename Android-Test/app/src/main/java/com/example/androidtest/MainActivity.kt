package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlin.time.ExperimentalTime

class MainActivity : AppCompatActivity() {

    private lateinit var plusBtn:Button
    private lateinit var minusBtn:Button
    private lateinit var countTxt:TextView
    private lateinit var fruitsTxt:TextView

    private var count = 0
    private var fruits = mutableListOf("A","B","C")
    //private lateinit var viewModel: MainViewModel

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        plusBtn = findViewById(R.id.plusBtn)
        minusBtn = findViewById(R.id.minusBtn)
        countTxt = findViewById(R.id.count)
        fruitsTxt = findViewById(R.id.fruitsTxt)

        plusBtn.setOnClickListener {
            viewModel.increment()
            /*count+=1
            countTxt.text = count.toString()*/

           /* fruitsTxt.text = ""
            fruits.add("New")
            fruits.forEach {
                fruitsTxt.text = "${fruitsTxt.text}, $it"
            }*/

        }

        minusBtn.setOnClickListener {
            viewModel.decrement()
           /* count-=1
            countTxt.text = count.toString()*/
        }

       /* fruits.forEach {
            fruitsTxt.text = "${fruitsTxt.text}, $it"
        }*/

        /*viewModel.countLiveData.observe(this){
            countTxt.text = it.toString()
        }*/

        lifecycleScope.launchWhenStarted {
            viewModel.countStateFlow.collectLatest {
                countTxt.text = it.toString()
            }
        }



    }
}