package com.example.harryporter.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val base_url="https://hp-api.onrender.com/api/characters"
        fun getRetroInstance() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}