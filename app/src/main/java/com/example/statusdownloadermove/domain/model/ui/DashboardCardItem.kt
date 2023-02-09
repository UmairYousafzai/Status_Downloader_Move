package com.example.statusdownloadermove.domain.model.ui

import androidx.compose.ui.graphics.Color
import com.example.statusdownloadermove.R

data class DashboardCardItem(
    val mainText: String = "",
    val color: Color = Color.White,
    val iconID: Int = R.drawable.ic_launcher_background,
    val iconTint: Color =Color.White,
    val iconContentDescription: String = ""
)