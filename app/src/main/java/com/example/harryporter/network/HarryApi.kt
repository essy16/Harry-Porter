package com.example.harryporter.network

import com.example.harryporter.data.HarryItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HarryApi {
    @GET("characters")
    suspend fun getHarryCharacters(): Response<List<HarryItem>>
}