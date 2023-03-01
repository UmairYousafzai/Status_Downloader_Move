package com.example.statusdownloadermove.presentation.dialogs

import android.app.Activity
import android.util.Log
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.documentfile.provider.DocumentFile

@Composable
fun PermissionInfoDialog(onClick: (Boolean) -> Unit) {

    Column(modifier = Modifier
        .background(Color.White)
        .padding(15.dp)
    ) {
        Text(
            text = "To Get All Statues",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 16.sp, color = Color.DarkGray)) {
                append("Allow access to")

            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                )
            ) {
                append("'WhatsApp Media'")
            }
            withStyle(style = SpanStyle(fontSize = 16.sp, color = Color.DarkGray)) {
                append("Folder")
            }
        })
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "This permission is necessary in order to fetch status from whats app status folder",
            fontSize = 15.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.align(End),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Cancel",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        onClick.invoke(false)
                    },
            )

            Text(
                text = "Grant Permission",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        onClick.invoke(true)

                    }
            )
        }
    }
}