package com.example.harryporter.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val base_url="https://hp-api.onrender.com/api/characters"
val retrofit=Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
interface HarryApiService{
    @GET("/api/characters")
   suspend fun getHarryCharacters()
}
object HarryApi{
    val retrofitService:HarryApiService by lazy {
        retrofit.create(HarryApiService::class.java)
    }
}
