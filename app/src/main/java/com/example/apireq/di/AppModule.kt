package com.example.apireq.di

import com.example.apireq.remote.AppApiService
import com.example.apireq.remote.repository.AppRepo
import com.example.apireq.remote.repository.AppRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppRepo(appApiService: AppApiService): AppRepo {
        return AppRepoImpl(appApiService)
    }

}