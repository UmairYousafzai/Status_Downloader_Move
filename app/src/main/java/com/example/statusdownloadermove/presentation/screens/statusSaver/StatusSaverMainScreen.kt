package com.example.statusdownloadermove.presentation.screens.statusSaver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.statusdownloadermove.R
import com.example.statusdownloadermove.presentation.screens.DashBoardScreen
import com.example.statusdownloadermove.ui.theme.DarkGreen
import com.example.statusdownloadermove.ui.theme.StatusDownloaderMoveTheme


@Composable
fun StatusSaverMainScreen(
    navController: NavController
) {

    Header()

}

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkGreen)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "back btn",
                tint = Color.White,
                modifier = Modifier.padding(5.dp)
            )

            Text(
                text = "Status Saver",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Image(
            painter = painterResource(id = R.drawable.whatsapp_icon),
            contentDescription = "whats app icon"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StatusDownloaderMoveTheme {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            modifier = Modifier.background(Color.White),
            scaffoldState = scaffoldState,

            ) {
            Header(modifier = Modifier.padding(it))
        }
    }

}