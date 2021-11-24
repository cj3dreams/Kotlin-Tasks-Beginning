package com.pseudoencom.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    private val actionBarTitle:MutableLiveData<String> = MutableLiveData()

    fun getTitle():LiveData<String> = actionBarTitle

    fun setTitle(title:String){
        actionBarTitle.value = title

    }
}