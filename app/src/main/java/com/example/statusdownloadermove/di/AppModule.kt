package com.example.statusdownloadermove.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun providesRepository(
//        api: Api
//    )=PokemonRepository(api)
//
//    @Provides
//    @Singleton
//    fun providesApi():Api
//    {
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://pokeapi.co/api/v2/")
//            .client(getLoggingInterceptor().build())
//            .build()
//            .create(Api::class.java)
//    }
//    private fun getLoggingInterceptor(): OkHttpClient.Builder {
//        val loggingIntercepter = HttpLoggingInterceptor()
//        loggingIntercepter.level = HttpLoggingInterceptor.Level.BODY
//
//        val builder = OkHttpClient().newBuilder()
//        builder.readTimeout(30, TimeUnit.SECONDS)
//        builder.connectTimeout(30, TimeUnit.SECONDS)
//        builder.writeTimeout(30, TimeUnit.SECONDS)
//        builder.addInterceptor(loggingIntercepter)
//        return builder
//    }
}