package com.devocean.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.devocean.feature.home.component.CategoryTopBar
import com.devocean.feature.home.component.HomeTopBar

@Composable
fun HomeRoute(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        viewModel = viewModel
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    onProfileClick: () -> Unit = {},
    onFixClick: () -> Unit = {},
    onCategoryClick: () -> Unit = {}
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
        Column()
        {

        }
    }
}