package com.example.statusdownloadermove.presentation.screens.statusSaver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.statusdownloadermove.presentation.uitls.getTabRows
import com.example.statusdownloadermove.ui.theme.DarkGreen
import com.example.statusdownloadermove.ui.theme.StatusDownloaderMoveTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.TabPlacement


@OptIn(ExperimentalPagerApi::class)
@Composable
fun StatusSaverMainScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState()

    Column {
        Header()
        TabLayout(pagerState = pagerState)
        HorizontalPager(
            count = getTabRows().size,
            state = pagerState,
        ) {
            getTabRows()[pagerState.currentPage].screen()
        }
    }

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


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
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

        CustomTabs(pagerState = pagerState)

    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabs(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    val coroutineState = rememberCoroutineScope()
    getTabRows().forEachIndexed { index, tabRowItem ->
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