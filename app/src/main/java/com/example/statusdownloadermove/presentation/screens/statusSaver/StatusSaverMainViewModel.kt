package com.example.statusdownloadermove.presentation.screens.statusSaver

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.statusdownloadermove.data.repository.statusSaver.abstraction.StatusSaverRepository
import com.example.statusdownloadermove.domain.model.ui.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatusSaverMainViewModel @Inject constructor(
    private val statusSaverRepository: StatusSaverRepository
) : ViewModel() {

    var imageItems = mutableStateOf(listOf<Status>())
    var videoItems = mutableStateOf(listOf<Status>())

    fun getImageItems(uri: String, mediaType: String = ".jpg") {
        viewModelScope.launch(Dispatchers.IO) {
            statusSaverRepository.getMediaItems(uri, mediaType) {
                if (imageItems.value.size != it.size) {
                    imageItems.value = it
                }
            }
        }
    }

    fun getVideoItems(uri: String, mediaType: String = ".mp4") {
        viewModelScope.launch(Dispatchers.IO) {
            statusSaverRepository.getMediaItems(uri, mediaType) {
                if (videoItems.value.size != it.size) {
                    videoItems.value = it
                }
            }
        }
    }

}