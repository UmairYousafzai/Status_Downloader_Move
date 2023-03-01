package com.example.statusdownloadermove.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore


const val APP_PREFERENCES = "status_downloader_move_preferences"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = APP_PREFERENCES)


const val STATUS_FOLDER_PATH = "status.folder.path"



val FOLDER_PATH = stringPreferencesKey(STATUS_FOLDER_PATH)
