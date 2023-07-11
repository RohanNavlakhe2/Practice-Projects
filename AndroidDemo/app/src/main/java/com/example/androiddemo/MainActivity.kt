package com.example.androiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovieData()
    }

    private fun getMovieData(){
        lifecycleScope.launch {
            viewModel.getMovieList("marvel").collectLatest { result ->
                when(result){

                    is NetworkResult.Loading -> {
                        Log.d("Krish","Loading")
                    }

                    is NetworkResult.Success -> {
                        Log.d("Krish",result.data.Search.toString())
                    }

                    else -> {}
                }
            }
        }
    }








}