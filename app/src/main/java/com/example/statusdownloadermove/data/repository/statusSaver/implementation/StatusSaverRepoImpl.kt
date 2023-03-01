package com.example.statusdownloadermove.data.repository.statusSaver.implementation

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.*
import androidx.documentfile.provider.DocumentFile
import com.example.statusdownloadermove.data.repository.statusSaver.abstraction.StatusSaverRepository
import com.example.statusdownloadermove.domain.model.ui.Status
import com.example.statusdownloadermove.utils.FOLDER_PATH
import com.example.statusdownloadermove.utils.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StatusSaverRepoImpl(private val context: Context) :
    StatusSaverRepository {

    override suspend fun getMediaItems(
        uri: String,
        mediaType: String,
        onResult: (ArrayList<Status>) -> Unit
    ) {

        if (uri.isNotEmpty()) {

            val documentFile = uri.let { DocumentFile.fromTreeUri(context, Uri.parse(uri)) }
            val files = documentFile?.listFiles()
            Log.e("Status uri", "file size====> ${files?.size}")

            val statusList = ArrayList<Status>()
            files?.forEach {
                if (it.name?.endsWith(mediaType) == true) {
                    statusList.add(Status(it.uri.toString(), it.name ?: ""))
                }
            }
            onResult.invoke(statusList)
        }
    }

}