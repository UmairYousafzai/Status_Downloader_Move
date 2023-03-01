package com.example.statusdownloadermove.presentation.screens.statusSaver

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.statusdownloadermove.R
import com.example.statusdownloadermove.domain.model.ui.TabRowItem
import com.example.statusdownloadermove.presentation.dialogs.PermissionInfoDialog
import com.example.statusdownloadermove.presentation.uitls.getTabRows
import com.example.statusdownloadermove.presentation.viewModels.datastore.DataStoreViewModel
import com.example.statusdownloadermove.ui.theme.DarkGreen
import com.example.statusdownloadermove.ui.theme.StatusDownloaderMoveTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StatusSaverMainScreen(
    navController: NavController,
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),

    ) {
    val tabRowList by remember {
        mutableStateOf(getTabRows())
    }
    val pagerState = rememberPagerState()
    val folderPath by remember {
        dataStoreViewModel.folderPath
    }
    val context = LocalContext.current
    dataStoreViewModel.getStatusFolderPath()

    Column {
        val requestPermissionLauncher =
            rememberLauncherForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val uri = result.data?.data
                    Log.e("Status uri", "uri====> ${uri.toString()}")
                    dataStoreViewModel.saveStatusFolderPath(uri.toString())
                    saveFolderAccessPermission(uri, context)
                }
            }
        StatusSaverHeader(navController = navController)
        TabLayout(tabRowList, pagerState = pagerState)
        HorizontalPager(
            count = tabRowList.size,
            state = pagerState,
        ) {
            if (folderPath.isEmpty()) {
                Dialog(
                    onDismissRequest = { },
                    content = {
                        PermissionInfoDialog()
                        {
                            if (it) {
                                requestStatusFolderAccessPermission(requestPermissionLauncher)
                            }
                        }
                    },
                )
            } else {
                tabRowList[currentPage].screen.invoke(folderPath, navController)
            }
        }
    }
}

@Composable
fun StatusSaverHeader(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Row(
        modifier = modifier
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
                modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                        navController.popBackStack()
                    },
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


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
    tabsList: List<TabRowItem>,
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions = tabPositions),
                color = Color.White
            )
        },
        backgroundColor = DarkGreen,
    ) {
        CustomTabs(tabsList, pagerState = pagerState)
    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabs(
    tabsList: List<TabRowItem>,
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    val coroutineState = rememberCoroutineScope()

    tabsList.forEachIndexed { index, tabRowItem ->
        Tab(
            selected = pagerState.currentPage == index,
            onClick = { coroutineState.launch { pagerState.animateScrollToPage(index) } },
            icon = {
                Icon(
                    painter = painterResource(id = tabRowItem.icon),
                    contentDescription = tabRowItem.title
                )
            },
            text = {
                Text(text = tabRowItem.title)
            }
        )
    }

}

