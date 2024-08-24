package com.devocean.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.component.button.HomeCategoryButton
import com.devocean.feature.R

@Composable
fun CategoryTopBar(
    modifier: Modifier = Modifier,
    onCategoryClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        HomeCategoryButton(
            paddingVertical = 1.dp,
            onButtonClick = { onCategoryClick() },
            text = stringResource(id = R.string.home_category_first)
        )
        HomeCategoryButton(
            paddingVertical = 1.dp,
            onButtonClick = { onCategoryClick() },
            text = stringResource(id = R.string.home_category_first)
        )
    }
}
