package com.example.statusdownloadermove.presentation.screens.statusSaver

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.example.statusdownloadermove.domain.model.ui.photoViewer.PhotoViewerArgument
import com.example.statusdownloadermove.presentation.components.MediaCard
import com.example.statusdownloadermove.presentation.uitls.Screen
import com.google.gson.Gson


@Composable
fun PhotosScreen(
    uri: String,
    navController: NavController,
    statusViewModel: StatusSaverMainViewModel = hiltViewModel()
) {
    Log.e("start", "uri====> ${uri}")

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    var isInForeground by remember { mutableStateOf(true) }
    var isClick by remember { mutableStateOf(true) }

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


    val imageList by remember {
        statusViewModel.imageItems
    }
    if (isInForeground) {
        statusViewModel.getImageItems(uri, ".jpg")
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
                items(imageList) { item ->
                    MediaCard(isClicked = isClick, status = item) {

                        if (isClick) {
                            val args = Gson().toJson(
                                PhotoViewerArgument(
                                    imageList,
                                    imageList.indexOf(item)
                                )
                            )
                            navController
                                .navigate(
                                    Screen.PhotoViewer.route + "/$args"
                                )
                            isClick= false
                        }
                    }
                }
            })

    }
}

