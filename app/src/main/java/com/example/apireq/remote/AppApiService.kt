package com.example.apireq.remote

import com.example.apireq.data.Animal
import com.example.apireq.resource.Response
import retrofit2.http.GET


interface AppApiService {
    @GET("amphibians")
    suspend fun getAnimals(): List<Animal>
}