package com.example.harryporter.data

import kotlinx.serialization.Serializable

@Serializable
data class Wand(

    val core: String,
    val length: Double,
    val wood: String
)