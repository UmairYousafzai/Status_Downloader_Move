package com.example.statusdownloadermove.presentation.screens.statusSaver

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.statusdownloadermove.presentation.components.MediaCard


@Composable
fun VideoScreen(
    uri: String,
    statusViewModel: StatusSaverMainViewModel = hiltViewModel()
) {

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    var isInForeground by remember { mutableStateOf(true) }

    DisposableEffect(lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> isInForeground = true
                Lifecycle.Event.ON_STOP -> isInForeground = false
                else -> Unit
            }
        }

        lifecycle.addObserver(observer)
        onDispose { lifecycle.removeObserver(observer) }
    }

    val videoList by remember {
        statusViewModel.videoItems
    }

    if (isInForeground) {
        statusViewModel.getVideoItems(uri, ".mp4")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    )
    {


        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            columns = GridCells.Fixed(2),
            content = {
                items(videoList) { item ->
                    MediaCard(status = item){

                    }
                }
            })

    }
}
