package com.example.statusdownloadermove.presentation.screens.statusSaver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.statusdownloadermove.R
import com.example.statusdownloadermove.domain.model.ui.Status
import com.example.statusdownloadermove.domain.model.ui.photoViewer.PhotoViewerArgument
import com.example.statusdownloadermove.ui.theme.DarkGreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun PhotoViewerScreen(
    photoViewerArgument: PhotoViewerArgument,
    navController: NavController
) {
    val pagerState = rememberPagerState(photoViewerArgument.position)
    val imagesList by remember {
        mutableStateOf(photoViewerArgument.imagesList)
    }
    val headerTitle by remember {
        mutableStateOf(
            imagesList[pagerState.currentPage].documentFile.name
        )
    }

    HorizontalPager(count = imagesList.size, state = pagerState) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            PhotoViewerHeader(
                navController = navController,
                title = headerTitle
            )
            Spacer(modifier = Modifier.height(20.dp))
            val image = rememberAsyncImagePainter(model = imagesList[pagerState.currentPage])
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )

        }
    }
}

@Composable
fun PhotoViewerHeader(
    modifier: Modifier = Modifier,
    navController: NavController,
    title: String? = "new file"
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "back btn",
                tint = Color.White,
                modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                        navController.popBackStack()
                    },
            )

            title?.let {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        Icon(imageVector = Icons.Default.Share, contentDescription = "Share button")
        Icon(
            painter = painterResource(id = R.drawable.baseline_download_white_24dp),
            contentDescription = "download button"
        )


    }

}
