package com.example.statusdownloadermove

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.statusdownloadermove.presentation.screens.DashBoardScreen
import com.example.statusdownloadermove.presentation.screens.statusSaver.StatusSaverMainScreen
import com.example.statusdownloadermove.ui.theme.StatusDownloaderMoveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusDownloaderMoveTheme {
                val navController = rememberNavController()
                var topAppBarState = remember {
                    true
                }


                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute by remember { derivedStateOf { currentBackStackEntry?.destination?.route ?: "Home" } }

                Scaffold(
                    modifier = Modifier,
                    topBar = {
                        if (currentRoute!="status_saver_screen") {
                            TopAppBar(
                                title = {
                                    Text(text = stringResource(id = R.string.app_name))
                                },
                                backgroundColor = Color.White,
                                contentColor = MaterialTheme.colors.onPrimary,
                            )
                        }
                    },
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "dashboard_screen",
                        modifier = Modifier.padding(it)
                    ) {
                        composable("dashboard_screen") {
                            DashBoardScreen(navController = navController)
                        }
                        composable("status_saver_screen") {
                            StatusSaverMainScreen(navController = navController)
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
            scaffoldState = scaffoldState,

            ) {
            NavHost(
                navController = navController,
                startDestination = "status_saver_screen",
                modifier = Modifier.padding(it)
            ) {
                composable("dashboard_screen") {
                    DashBoardScreen(navController = navController)
                }
                composable("status_saver_screen") {
                    DashBoardScreen(navController = navController)
                }
            }

        }
    }

}