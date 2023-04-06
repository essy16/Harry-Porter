package com.example.harryporter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harryporter.repo.MainRepository

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory constructor(private val repository: MainRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HarryViewModel::class.java)){
            HarryViewModel(this.repository) as  T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}