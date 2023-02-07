package com.example.statusdownloadermove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.statusdownloadermove.presentation.screens.DashBoardScreen
import com.example.statusdownloadermove.ui.theme.StatusDownloaderMoveTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusDownloaderMoveTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(id = R.string.app_name))
                            },
                            backgroundColor = Color.White,
                            contentColor = MaterialTheme.colors.onPrimary,
                        )
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "dashboard_screen",
                        modifier = Modifier.padding(it)
                    ) {
                        composable("dashboard_screen") {
                            DashBoardScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StatusDownloaderMoveTheme {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            modifier = Modifier.background(Color.White),
            scaffoldState = scaffoldState ,

        ) {
            NavHost(
                navController = navController,
                startDestination = "dashboard_screen",
                modifier = Modifier.padding(it)
            ) {
                composable("dashboard_screen") {
                    DashBoardScreen(navController = navController)
                }
            }

        }
    }

}