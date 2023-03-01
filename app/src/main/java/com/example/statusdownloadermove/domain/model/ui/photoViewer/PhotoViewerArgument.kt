package com.example.statusdownloadermove.domain.model.ui.photoViewer

import com.example.statusdownloadermove.domain.model.ui.Status
import java.io.Serializable

data class PhotoViewerArgument(
    val imagesList: List<Status>? = null,
    val position: Int = 0
) : Serializable
