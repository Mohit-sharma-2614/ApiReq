package com.example.apireq.di

import com.example.apireq.remote.AppApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val Base_url = "https://android-kotlin-fun-mars-server.appspot.com/"

//    @Provides
//    @Singleton
//    fun json() : Json{
//        return Json {
//            ignoreUnknownKeys = true
//            coerceInputValues = true
//        }
//    }

    @Provides
    @Singleton
    fun retrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Base_url)
//            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : AppApiService {
        return retrofit.create(AppApiService::class.java)
    }

}