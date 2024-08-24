package com.devocean.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.SpotGray

@Composable
fun YoutubeItem(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    category: String = "",
    bookmark: Boolean = true,
    summary: String
) {
    Column(
        modifier = modifier
            .background(
                color = SpotGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
            .fillMaxSize(),
    ) {
        Image(
            image, contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
        Row(
            modifier = modifier.padding(top = 10.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
            )
        }
        Text(text = summary)
    }
}