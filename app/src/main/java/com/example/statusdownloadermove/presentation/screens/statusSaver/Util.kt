package com.example.statusdownloadermove.presentation.screens.statusSaver

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.documentfile.provider.DocumentFile
import com.example.statusdownloadermove.utils.FOLDER_PATH
import com.example.statusdownloadermove.utils.WHATS_APP_DIRECTORY_FOR_REQUEST
import java.io.File
import java.io.FileOutputStream

fun requestStatusFolderAccessPermission(
    requestPermissionLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
    intent.putExtra(
        "android.provider.extra.INITIAL_URI", Uri.parse(
            WHATS_APP_DIRECTORY_FOR_REQUEST
        )
    )
    requestPermissionLauncher.launch(intent)

}


fun saveFolderAccessPermission(uri: Uri?, context: Context) {
    val contentResolver = context.applicationContext.contentResolver
    val takeFlags: Int = Intent.FLAG_GRANT_READ_URI_PERMISSION or
            Intent.FLAG_GRANT_WRITE_URI_PERMISSION
    uri?.let { contentResolver.takePersistableUriPermission(it, takeFlags) }
}

@Composable
fun CopyFileFromUri(documentFile: DocumentFile) {
    val context = LocalContext.current
    val contentResolver = context.contentResolver

    val fileName = documentFile.name ?: System.currentTimeMillis().toString()
    val inputStream = contentResolver.openInputStream(documentFile.uri)
    val outputStream = FileOutputStream(File(context.filesDir, fileName))

    inputStream?.copyTo(outputStream)
    inputStream?.close()
    outputStream.close()

    // Show a confirmation message
    LaunchedEffect(Unit) {
        val message = "File copied successfully!"
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}