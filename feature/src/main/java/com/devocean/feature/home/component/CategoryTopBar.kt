package com.devocean.feature.home.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.devocean.feature.R

@Composable
fun CategoryTopBar(
    modifier: Modifier = Modifier,
    onCategoryClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = { onCategoryClick() }) {
            Text(text = stringResource(id = R.string.home_category_first))
        }
    }
}