package com.example.statusdownloadermove.presentation.uitls

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard_screen")
    object StatusSaver : Screen("status_saver_screen")
    object PhotoViewer : Screen("photo_viewer_screen")
}
