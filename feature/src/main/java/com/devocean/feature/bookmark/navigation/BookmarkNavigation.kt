package com.devocean.feature.bookmark.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devocean.core.navigation.MainTabRoute
import com.devocean.feature.bookmark.BookmarkRoute
import kotlinx.serialization.Serializable


fun NavController.navigateBookmark(navOptions: NavOptions? = null) {
    navigate(
        route = Bookmark,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.bookmarkNavGraph(
    navHostController: NavHostController,
) {
    composable<Bookmark> {
        BookmarkRoute(
        )
    }
}

@Serializable
data object Bookmark : MainTabRoute