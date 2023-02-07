package com.example.statusdownloadermove.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

//    @Singleton
//    @Provides
//    fun provideDatabase(application: Application): Database {
//        return Database.getDatabase(application)
//    }
}