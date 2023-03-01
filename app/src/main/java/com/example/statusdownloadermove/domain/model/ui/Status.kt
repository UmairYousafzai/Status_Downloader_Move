package com.example.statusdownloadermove.domain.model.ui

import android.os.Parcel
import android.os.Parcelable
import androidx.documentfile.provider.DocumentFile
import java.io.File
import java.io.Serializable

@kotlinx.serialization.Serializable
data class Status(
    val uri: String = "",
    val name: String = "",
    var isVideo: Boolean = false
):Serializable {

    init {
        isVideo = name.endsWith(".jpg") != true
    }

}