package com.example.statusdownloadermove.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

//    @Singleton
//    @Provides
//    fun provideRepository(
//        database: Database
//    ): Repository = RepositoryImpl(database)
}