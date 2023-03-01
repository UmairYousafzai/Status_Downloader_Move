package com.example.statusdownloadermove.presentation.components

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun VideoThumbnail(
    videoUri: Uri,
    thumbnailWidth: Dp,
    thumbnailHeight: Dp
) {
    val context = LocalContext.current

    var thumbnail by remember {
        mutableStateOf<Bitmap?>(null)
    }
    LaunchedEffect(key1 = videoUri) {
        val requestOptions = RequestOptions()
            .frame(0)
            .centerCrop()

        withContext(Dispatchers.IO) {
            val bitmap = Glide.with(context)
                .asBitmap()
                .load(videoUri)
                .apply(requestOptions)
                .submit()
                .get()
            thumbnail = bitmap

        }

    }
    thumbnail?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(width = thumbnailWidth, height = thumbnailHeight)
        )
    }
}
