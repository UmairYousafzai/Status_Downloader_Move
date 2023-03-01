package com.example.statusdownloadermove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.statusdownloadermove.domain.model.ui.photoViewer.PhotoViewerArgument
import com.example.statusdownloadermove.presentation.screens.DashBoardScreen
import com.example.statusdownloadermove.presentation.screens.statusSaver.PhotoViewerScreen
import com.example.statusdownloadermove.presentation.screens.statusSaver.StatusSaverMainScreen
import com.example.statusdownloadermove.presentation.uitls.NavigationArgs
import com.example.statusdownloadermove.presentation.uitls.PhotoViewerArgumentType
import com.example.statusdownloadermove.presentation.uitls.Screen
import com.example.statusdownloadermove.ui.theme.StatusDownloaderMoveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            StatusDownloaderMoveTheme {
                val navController = rememberNavController()

                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute by remember {
                    derivedStateOf {
                        currentBackStackEntry?.destination?.route ?: "Home"
                    }
                }

                Scaffold(
                    modifier = Modifier,
                    topBar = {
                        if (currentRoute != "status_saver_screen") {
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
                        startDestination = Screen.Dashboard.route,
                        modifier = Modifier.padding(it)
                    ) {

                        composable(Screen.Dashboard.route) {
                            DashBoardScreen(navController = navController)
                        }
                        composable(Screen.StatusSaver.route) {
                            StatusSaverMainScreen(navController = navController)
                        }
                        composable(
                            Screen.PhotoViewer.route +
                                    "/{${NavigationArgs.PHOTO_VIEWER_ARGS.name}}",
                            arguments = listOf(
                                navArgument(NavigationArgs.PHOTO_VIEWER_ARGS.name) {
                                    type = PhotoViewerArgumentType
                                    defaultValue = PhotoViewerArgument(emptyList())
                                },
                            )
                        ) {
                            val photoViewerArgument = remember {
                                it.arguments!!.getSerializable(NavigationArgs.PHOTO_VIEWER_ARGS.name)
                                        as PhotoViewerArgument
                            }

                            PhotoViewerScreen(
                                navController = navController,
                                photoViewerArgument = photoViewerArgument,
                            )
                        }

                    }

                }
            }
        }
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