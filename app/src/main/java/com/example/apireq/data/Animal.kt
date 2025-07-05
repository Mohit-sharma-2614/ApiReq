package com.example.apireq.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Animal(
    val name: String,
    val type: String,
    val description: String,
    @SerializedName("img_src")
//    @SerialName("img_src")
    val cardImg: String
)
