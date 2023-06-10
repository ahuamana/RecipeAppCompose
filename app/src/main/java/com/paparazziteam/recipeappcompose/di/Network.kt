package com.paparazziteam.recipeappcompose.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverter :GsonConverterFactory) = Retrofit.Builder()
    .baseUrl("https://food2fork.ca/api/")
        .addConverterFactory(gsonConverter)
    .build()

    @Provides
    @Singleton
    fun provideConverterFactory() = GsonConverterFactory.create(
        GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
    )
}