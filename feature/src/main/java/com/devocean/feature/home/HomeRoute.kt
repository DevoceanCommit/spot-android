package com.devocean.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.R
import com.devocean.feature.home.component.CategoryTopBar
import com.devocean.feature.home.component.HomeTopBar
import com.devocean.feature.home.component.YoutubeItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onFixClick: () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    val mockDataList = listOf(
        YouTubeData(
            image = painterResource(id = R.drawable.img_youtube_default_pic),
            title = "Heading",
            category = "카테고리",
            bookmark = false,
            summary = "한줄요약"
        ),
        YouTubeData(
            image = painterResource(id = R.drawable.img_youtube_default_pic),
            title = "Heading",
            category = "카테고리",
            bookmark = false,
            summary = "한줄요약"
        )
    )

    HomeScreen(
        dataList = mockDataList,
        onSearchClick = { search ->
            viewModel.fetchSearch(search)
        },
        onFixClick = { onFixClick() }
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onProfileClick: () -> Unit = {},
    onFixClick: () -> Unit = {},
    onCategoryClick: () -> Unit = {},
    onSearchClick: (String) -> Unit = {},
    dataList: List<YouTubeData>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        HomeTopBar(
            value = "",
            onValueChanged = { search ->
                onSearchClick(search)
            },
            onProfileClick = {
                onProfileClick()
            },
            onFixClick = {
                onFixClick()
            }
        )
        Divider(thickness = 2.dp, color = SpotGray)
        CategoryTopBar(
            onCategoryClick = { onCategoryClick() }
        )
        Divider(thickness = 2.dp, color = SpotGray)
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(dataList) { item ->
                Box(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    YoutubeItem(
                        image = item.image,
                        title = item.title,
                        category = item.category,
                        bookmark = item.bookmark,
                        summary = item.summary,
                        isBookmark = true,
                        spotDate = "spot date: 10/14"
                    )
                }
            }
        }
    }
}