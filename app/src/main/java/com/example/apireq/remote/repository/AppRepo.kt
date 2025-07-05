package com.example.apireq.remote.repository

import com.example.apireq.data.Animal
import com.example.apireq.resource.Response

interface AppRepo {
    suspend fun getAllAnimals (): Response
}