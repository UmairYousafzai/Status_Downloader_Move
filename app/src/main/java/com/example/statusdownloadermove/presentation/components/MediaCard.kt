package com.example.statusdownloadermove.presentation.components

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.media.ThumbnailUtils
import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toFile
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.statusdownloadermove.domain.model.ui.Status
import com.example.statusdownloadermove.presentation.uitls.Screen


@Composable
fun MediaCard(
    modifier: Modifier = Modifier,
    status: Status,
    isClicked: Boolean = false,
    onClick: () -> Unit
) {


    Card(
        modifier = modifier
            .size(width = 60.dp, height = 150.dp)
            .clickable {
                onClick.invoke()
            },
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(2.dp, Color.White),
        elevation = 5.dp,
    ) {

        if (status.isVideo) {
            VideoThumbnail(
                videoUri = Uri.parse(status.uri),
                thumbnailHeight = 150.dp,
                thumbnailWidth = 60.dp
            )
        } else {
            Image(
                painter = rememberAsyncImagePainter(model = status.uri),
                contentDescription = status.name,
                contentScale = ContentScale.Inside
            )
        }

    }

}
