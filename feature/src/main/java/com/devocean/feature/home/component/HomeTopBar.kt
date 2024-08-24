package com.devocean.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devocean.feature.R

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    onFixClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HomeTopButton(
            onButtonClick = { onFixClick() },
            painterResource = R.drawable.ic_pin_24,
            paddingVertical = 10.dp
        )
        TextField(value = value, onValueChange = onValueChanged)
        Button(onClick = {
            onProfileClick()
        }) {
            Image(
                painter = painterResource(id = R.drawable.img_person),
                contentDescription = null,
                modifier = modifier.size(40.dp)
            )
        }
    }
}