package com.example.statusdownloadermove.presentation.uitls

import android.os.Bundle
import androidx.navigation.NavType
import com.example.statusdownloadermove.domain.model.ui.photoViewer.PhotoViewerArgument
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

val PhotoViewerArgumentType = object : NavType<PhotoViewerArgument>(
    isNullableAllowed = false
) {
    override fun put(
        bundle: Bundle, key: String, value: PhotoViewerArgument
    ) {
        bundle.putSerializable(key, value)
    }

    override fun get(bundle: Bundle, key: String): PhotoViewerArgument {
        return bundle.getSerializable(key) as PhotoViewerArgument
    }

    override fun parseValue(value: String): PhotoViewerArgument {
        return Json.decodeFromString(value)
    }

    // Only required when using Navigation 2.4.0-alpha07 and lower
    override val name = "PhotoViewerArgument"
}