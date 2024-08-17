package com.devocean.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
        Button(onClick = { onFixClick() }) {
            Image(
                painter = painterResource(id = R.drawable.ic_push_pin_24),
                contentDescription = null
            )
        }
        TextField(value = value, onValueChange = onValueChanged)
        Button(onClick = { onProfileClick() }) {
            Image(
                painter = painterResource(id = R.drawable.ic_person_24),
                contentDescription = null
            )
        }
    }
}