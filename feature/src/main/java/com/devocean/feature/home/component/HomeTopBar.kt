package com.devocean.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.component.button.HomeTopButton
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
        HomeSearchTextField(
            value = value,
            onValueChange = onValueChanged,
            leftIcon = R.drawable.ic_search_24,
            hint = stringResource(id = R.string.home_text_field_hint),
            modifier = Modifier.weight(1f)
        )
        HomeTopButton(
            onButtonClick = { onProfileClick() },
            painterResource = R.drawable.ic_person_24,
            paddingVertical = 10.dp
        )
    }
}