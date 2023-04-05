package com.example.harryporter.network

import com.example.harryporter.data.HarryItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
private const val base_url = "https://hp-api.onrender.com/api/"


interface HarryApi {
    @GET("characters")
    suspend fun getHarryCharacters(): Response<List<HarryItem>>
    companion object {
        private lateinit var retrofitService: HarryApi

        fun getInstance():HarryApi{

            return retrofitService
            }



    }
}