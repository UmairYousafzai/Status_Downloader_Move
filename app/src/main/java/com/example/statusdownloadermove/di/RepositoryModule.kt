package com.example.statusdownloadermove.di

import android.content.Context
import com.example.statusdownloadermove.data.repository.dataStore.abstraction.DataStoreRepository
import com.example.statusdownloadermove.data.repository.dataStore.implementation.DataStoreRepoImpl
import com.example.statusdownloadermove.data.repository.statusSaver.abstraction.StatusSaverRepository
import com.example.statusdownloadermove.data.repository.statusSaver.implementation.StatusSaverRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository = DataStoreRepoImpl(context)

    @Provides
    fun provideStatusSaverRepository(
        @ApplicationContext context: Context
    ): StatusSaverRepository = StatusSaverRepoImpl(context)


}