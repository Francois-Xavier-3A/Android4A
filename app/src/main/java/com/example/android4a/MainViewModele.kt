package com.example.android4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModele : ViewModel(){


    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun onClickIncrement(){
        counter.value = (counter.value ?: 0) + 1
    }
}