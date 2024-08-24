package com.devocean.feature.home

import androidx.compose.ui.graphics.painter.Painter

data class YouTubeData(
    val image: Painter,
    val title: String,
    val category: String,
    val bookmark: Boolean,
    val summary: String
)