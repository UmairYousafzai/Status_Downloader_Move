package com.example.statusdownloadermove.presentation.uitls

import androidx.compose.ui.graphics.Color
import com.example.statusdownloadermove.R
import com.example.statusdownloadermove.domain.model.DashboardCardItem
import com.example.statusdownloadermove.ui.theme.DarkGreen
import com.example.statusdownloadermove.ui.theme.lightBlue
import com.example.statusdownloadermove.ui.theme.orange


fun getDashBoardCardItems(): ArrayList<DashboardCardItem> {
    return arrayListOf(
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
}