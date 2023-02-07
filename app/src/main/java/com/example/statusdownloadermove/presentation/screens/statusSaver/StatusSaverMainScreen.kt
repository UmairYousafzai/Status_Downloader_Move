package com.example.statusdownloadermove.presentation.screens.statusSaver

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.statusdownloadermove.R


@Composable
fun StatusSaverMainScreen(
    navController: NavController
) {


}

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Row {
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            contentDescription = "back btn",
            tint = Color.White,
            modifier = Modifier.padding(5.dp)
        )

        Text(text = "Status Saver")
        Icon(painter = , contentDescription = )
    }
}