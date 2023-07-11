package com.example.androidtest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel:ViewModel() {

    private var count = 0

    private val _countLiveData = MutableLiveData(count)
    val countLiveData = _countLiveData

    private val _countStateFlow = MutableStateFlow(count)
    val countStateFlow = _countStateFlow


    fun increment(){
        //_countLiveData.postValue(++count)
        _countStateFlow.value = ++count
    }

    fun decrement(){
        //_countLiveData.postValue(--count)
        _countStateFlow.value = --count
    }
}