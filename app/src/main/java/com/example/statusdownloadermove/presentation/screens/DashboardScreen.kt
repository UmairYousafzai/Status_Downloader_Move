package com.example.statusdownloadermove.presentation.screens

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.statusdownloadermove.domain.model.DashboardCardItem
import com.example.statusdownloadermove.presentation.uitls.getDashBoardCardItems


@Composable
fun DashBoardScreen(
    navController: NavController
) {

    Surface(
        color = Color.White, modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
    ) {
        Column {
            LazyVerticalGrid(modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                columns = GridCells.Fixed(2),
                content = {
                    items(getDashBoardCardItems()) { item ->
                        CustomCard(item = item, navController = navController)
                    }
                })
        }

    }


}


@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    item: DashboardCardItem,
    navController: NavController
) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .clickable {
                if (item.mainText == "Status Download") {
                    navController.navigate("status_saver_screen")
                }
            },
        shape = MaterialTheme.shapes.medium,
        backgroundColor = item.color,
        border = BorderStroke(2.dp, Color.White),
        elevation = 5.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(item.iconID),
                    tint = item.iconTint,
                    contentDescription = item.iconContentDescription,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .padding(10.dp),
                )
                Icon(
                    painter = painterResource(item.iconID),
                    tint = item.iconTint.copy(alpha = 0.3f),
                    contentDescription = item.iconContentDescription,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp),
                )
            }

            Text(
                text = item.mainText,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp, 40.dp, 0.dp, 10.dp)
                    .align(Alignment.Start)
            )

        }
    }
}