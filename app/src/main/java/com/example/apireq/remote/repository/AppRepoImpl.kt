package com.example.apireq.remote.repository

import com.example.apireq.data.Animal
import com.example.apireq.remote.AppApiService
import com.example.apireq.resource.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json
import javax.inject.Inject


class AppRepoImpl @Inject constructor(
    private val appApiService: AppApiService
): AppRepo {
    override suspend fun getAllAnimals(): Response {
        return try {
            Response.Loading
            val animals = appApiService.getAnimals()
            Response.Success(animals)
        } catch (e: Exception){
            Response.Error(e.message.toString())
        }
    }
}