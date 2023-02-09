package com.example.statusdownloadermove.presentation.uitls

import androidx.compose.material.icons.Icons
import com.example.statusdownloadermove.R
import com.example.statusdownloadermove.domain.model.ui.DashboardCardItem
import com.example.statusdownloadermove.domain.model.ui.TabRowItem
import com.example.statusdownloadermove.presentation.screens.statusSaver.PhotosScreen
import com.example.statusdownloadermove.presentation.screens.statusSaver.SavedItemScreen
import com.example.statusdownloadermove.presentation.screens.statusSaver.VideoScreen
import com.example.statusdownloadermove.ui.theme.DarkGreen
import com.example.statusdownloadermove.ui.theme.lightBlue
import com.example.statusdownloadermove.ui.theme.orange


fun getDashBoardCardItems(): ArrayList<DashboardCardItem> =
    arrayListOf(
        DashboardCardItem(
            "Status Download",
            DarkGreen,
            R.drawable.baseline_download_white_24dp
        ),
        DashboardCardItem(
            "Direct Message",
            orange,
            R.drawable.baseline_message_24
        ),
        DashboardCardItem(
            "Recover Message",
            lightBlue,
            R.drawable.baseline_folder_delete_white_24dp
        ),
    )


fun getTabRows(): ArrayList<TabRowItem> =
    arrayListOf(
        TabRowItem("Photos", R.drawable.photo_icon, screen = { PhotosScreen() }),
        TabRowItem("Videos", R.drawable.video_icon, screen = { VideoScreen() }),
        TabRowItem("Saved", R.drawable.baseline_save_alt_24, screen = { SavedItemScreen() }),
    )