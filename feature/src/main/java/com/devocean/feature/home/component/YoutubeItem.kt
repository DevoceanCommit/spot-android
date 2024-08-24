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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.component.button.HomeCategoryButton
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.R

@Composable
fun YoutubeItem(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    category: String = "",
    bookmark: Boolean = true,
    summary: String,
    onCategoryClick: () -> Unit = {},
    isBookmark: Boolean = false,
    spotDate: String = "",
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
            modifier = modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
            )
            HomeCategoryButton(
                paddingVertical = 0.dp,
                onButtonClick = { onCategoryClick() },
                text = category,
                modifier = modifier.size(width = 56.dp, height = 20.dp)
            )
            Text(text = spotDate)
            if (isBookmark) Image(
                painter = painterResource(id = R.drawable.img_bookmark_32),
                contentDescription = null
            )
            else Image(
                painter = painterResource(id = R.drawable.img_bookmark_unselected_32),
                contentDescription = null
            )
        }
        Text(text = summary)
    }
}