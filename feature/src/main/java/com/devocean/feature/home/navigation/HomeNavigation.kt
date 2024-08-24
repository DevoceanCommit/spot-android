package com.devocean.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devocean.core.navigation.MainTabRoute
import com.devocean.feature.home.HomeRoute
import com.devocean.feature.mypage.navigation.navigateMyPage
import kotlinx.serialization.Serializable

fun NavController.navigateHome(navOptions: NavOptions? = null) {
    navigate(
        route = Home,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController,
) {
    composable<Home> {
        HomeRoute(
            onProfileClick = { navHostController.navigateMyPage() }
        )
    }
}


@Serializable
data object Home : MainTabRoute