package com.example.apireq.resource

import com.example.apireq.data.Animal

sealed class Response {
    object Loading: Response()
    data class Success(val data: List<Animal>): Response()
    data class Error(val message: String): Response()
}