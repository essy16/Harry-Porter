package com.example.harryporter.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    val api:HarryApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/characters")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryApi::class.java)



    }



}