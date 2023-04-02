package com.example.harryporter.retrofit

import com.example.harryporter.data.HarryItem
import retrofit2.Response
import retrofit2.http.GET

interface HarryApi {
    @GET("/api/characters")
    fun getHarryCharacters(): Response<List<HarryItem>>
}