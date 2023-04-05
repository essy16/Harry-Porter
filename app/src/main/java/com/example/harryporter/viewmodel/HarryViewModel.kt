package com.example.harryporter.viewmodel

//import javax.security.auth.callback.Callback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.harryporter.data.HarryItem
import com.example.harryporter.repo.MainReporsitory
import kotlinx.coroutines.*


class HarryViewModel constructor(private val viewRepository: MainReporsitory) : ViewModel() {
    val harryList = MutableLiveData<List<HarryItem>>()
    val errorMessage = MutableLiveData<String>()
    private var job: Job? = null
    val loading = MutableLiveData<Boolean>()
//    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        onError("Exception handled: ${throwable.localizedMessage}")
//    }


    fun getHarryCharacters() {
        job =viewModelScope.launch {
            val response = viewRepository.getHarryCharacters()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    harryList.postValue(response.body())
                    loading.value = false

                } else {
                    onError("Error : ${response.message()} ")


                }


            }


        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()

    }
    init {
        getHarryCharacters()
    }
}




