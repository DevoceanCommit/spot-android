package com.devocean.feature.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.devocean.core.navigation.MainTabRoute
import com.devocean.feature.R
import com.devocean.feature.bookmark.navigation.Bookmark
import com.devocean.feature.home.navigation.Home

enum class MainTab(
    @DrawableRes val icon: Int,
    val route: MainTabRoute,
) {
    HOME(
        icon = R.drawable.baseline_home_24,
        route = Home
    ),
    BOOKMARK(
        icon = R.drawable.baseline_bookmark_24,
        route = Bookmark
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }
    }
}
