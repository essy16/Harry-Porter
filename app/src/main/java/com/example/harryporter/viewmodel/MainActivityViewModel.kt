package com.example.harryporter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harryporter.data.HarryItem
import com.example.harryporter.retrofit.HarryApi
import com.example.harryporter.retrofit.RetroInstance
import javax.security.auth.callback.Callback

class MainActivityViewModel : ViewModel() {
    var liveDataList: MutableLiveData<List<HarryItem>> = MutableLiveData()


    fun getLiveDataObserver(): MutableLiveData<List<HarryItem>> {
        return liveDataList
    }

    fun makeApiCall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(HarryApi::class.java)
        val call = retroService.getHarryCharacters()
        call.enqueue(object : Callback<List<HarryItem>>)
    }
}
