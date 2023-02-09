package com.example.statusdownloadermove.domain.model.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.statusdownloadermove.R

data class TabRowItem(
    val title: String = "",
    val icon: Int = R.drawable.ic_launcher_background,
    val screen: @Composable () -> Unit,
)