package com.bhavanawagh.nailtheinterview.di

import com.bhavanawagh.nailtheinterview.api.QuestionsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl() : String {
        return "https://api.jsonbin.io"
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, gsonConverterFactory: GsonConverterFactory) : Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gsonConverterFactory).build()
    }

    @Singleton
    @Provides
    fun provideQuestionApi(retrofit: Retrofit) : QuestionsApi {
        return retrofit.create(QuestionsApi::class.java)
    }
}