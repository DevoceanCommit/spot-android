package com.devocean.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.devocean.feature.R
import com.devocean.feature.home.component.CategoryTopBar
import com.devocean.feature.home.component.HomeTopBar
import com.devocean.feature.home.component.YoutubeItem

@Composable
fun HomeRoute(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
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
        viewModel = viewModel,
        dataList = mockDataList
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    onProfileClick: () -> Unit = {},
    onFixClick: () -> Unit = {},
    onCategoryClick: () -> Unit = {},
    dataList: List<YouTubeData>
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        HomeTopBar(
            value = "",
            onValueChanged = { search ->
                viewModel.fetchSearch(search)
            },
            onProfileClick = {
                onProfileClick()
            },
            onFixClick = {
                onFixClick()
            }
        )
        CategoryTopBar(
            onCategoryClick = { onCategoryClick() }
        )
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(dataList) { item ->
                YoutubeItem(
                    image = item.image,
                    title = item.title,
                    category = item.category,
                    bookmark = item.bookmark,
                    summary = item.summary
                )
            }
        }
    }
}
