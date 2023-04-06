package com.example.harryporter.repo

import com.example.harryporter.network.HarryApi

class MainRepository(private val api: HarryApi) {
    suspend fun getHarryCharacters() = api.getHarryCharacters()

}