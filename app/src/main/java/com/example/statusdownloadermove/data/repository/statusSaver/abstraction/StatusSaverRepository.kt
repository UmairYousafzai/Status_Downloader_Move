package com.example.statusdownloadermove.data.repository.statusSaver.abstraction

import com.example.statusdownloadermove.domain.model.ui.Status
import kotlinx.coroutines.flow.Flow

interface StatusSaverRepository {
    suspend fun getMediaItems(uri: String,mediaType:String, onResult: (ArrayList<Status>) -> Unit)

}