package com.example.statusdownloadermove.data.repository.dataStore.abstraction

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun putString(key: String, value: String)
    suspend fun putLong(key: String, value: Long)
    suspend fun putInt(key: String, value: Int)
    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String): Boolean
    suspend fun getString(key: String): String
    suspend fun getInt(key: String): Int?

    val statusFolderPath: Flow<String>
}