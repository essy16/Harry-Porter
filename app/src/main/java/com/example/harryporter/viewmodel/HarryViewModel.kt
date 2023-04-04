package com.example.harryporter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harryporter.data.HarryItem
import com.example.harryporter.retrofit.HarryApiService
import kotlinx.coroutines.launch
//import javax.security.auth.callback.Callback
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response


class HarryViewModel : ViewModel() {
    val harryList = MutableLiveData<List<HarryItem>>()

    fun getHarrys() {
        viewModelScope.launch {
            HarryApiService.api.getHarryCharacters().enqueue(object : Callback<List<HarryItem>> {
                override fun onResponse(
                    call: Call<List<HarryItem>>,
                    response: Response<List<HarryItem>>
                ) {
                    if (response.body() != null) {
                        harryList.value = response.body()!!
                    } else {
                        return
                    }
                }

                override fun onFailure(call: Call<List<HarryItem>>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
        }


    }

    fun observeHarryLiveData(): LiveData<List<HarryItem>> {
        return harryList
    }
}




