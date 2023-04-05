package com.example.harryporter.repo

import com.example.harryporter.network.HarryApi

class MainReporsitory(private val api: HarryApi) {
    suspend fun getHarryCharacters() = api.getHarryCharacters()

}