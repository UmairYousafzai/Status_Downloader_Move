package com.example.statusdownloadermove.presentation.viewModels.datastore

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.statusdownloadermove.data.repository.dataStore.abstraction.DataStoreRepository
import com.example.statusdownloadermove.utils.STATUS_FOLDER_PATH
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(private val repository: DataStoreRepository) :
    ViewModel() {

    var folderPath = mutableStateOf("")

    fun saveStatusFolderPath(path: String) {
        viewModelScope.launch {
            repository.putString(STATUS_FOLDER_PATH, path)
        }
    }

    fun getStatusFolderPath() {
        viewModelScope.launch {
            repository.statusFolderPath.collect {
                folderPath.value = it
            }
        }
    }


}