package com.devocean.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.devocean.feature.R

@Composable
fun YoutubeItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.background(Color.Gray)
    ) {
        Image(painterResource(id = R.drawable.img_youtube_default_pic), contentDescription = null)
        Row(

        ){
            Text(text = "Heading")
        }
        Text(text = "요약")
    }
}