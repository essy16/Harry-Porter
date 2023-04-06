package com.example.harryporter.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.Serializable
@Parcelize
@Serializable
data class Wand(

    val core: String,
    val length: Double,
    val wood: String
):Parcelable