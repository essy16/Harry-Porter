package com.example.harryporter.viewmodel

//import javax.security.auth.callback.Callback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harryporter.data.HarryItem
import com.example.harryporter.repo.MainRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class HarryViewModel constructor(private val viewRepository: MainRepository) : ViewModel() {
    val harryList = MutableLiveData<List<HarryItem>>()
    val errorMessage = MutableLiveData<String>()
    private val _searchedCharacter = MutableStateFlow(emptyList<HarryItem>())
    val searchedCharacter = _searchedCharacter.asStateFlow()
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
    fun searchCharacter(characterList: List<HarryItem>, query: String): List<HarryItem> {
        return characterList.filter {
            it.name.lowercase().contains(query.lowercase()) ||
                    it.house.lowercase().contains(query)
        } ?: emptyList()
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




