package com.devocean.feature.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.devocean.core.designsystem.theme.DevoceanSpotTheme

@Composable
fun BookmarkRoute(
    navController: NavHostController,
) {

}

@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookmarkScreenPreview() {
    DevoceanSpotTheme {
        BookmarkScreen()
    }
}