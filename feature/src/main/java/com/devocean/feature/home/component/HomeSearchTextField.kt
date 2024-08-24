package com.devocean.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.SpotGray

@Composable
fun HomeSearchTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    textColor: Color = SpotGray,
    hintColor: Color = Color.Transparent,
    cursorBrush: Brush = SolidColor(Color.Black),
    leftIcon: Int? = null,
    leftIconColor: Color = Color.Black,
    imeAction: ImeAction = ImeAction.Done,
    maxTextLength: Int? = null,
    hint: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    onDoneAction: () -> Unit? = {},
    onSearchAction: () -> Unit? = {},
) {
    val isFocused: MutableState<Boolean> = remember { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = {
            if (maxTextLength == null || it.length <= maxTextLength + 1) {
                onValueChange(it)
            }
        },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = { onDoneAction() },
            onSearch = { onSearchAction() },
        ),
        modifier = modifier
            .onFocusChanged {
                isFocused.value = it.isFocused
            }
            .background(
                color = White,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = SpotGray,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)),
        cursorBrush = cursorBrush,
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                leftIcon?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        tint = leftIconColor,
                    )
                }
                Box(modifier = Modifier.wrapContentWidth()) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            color = if (isFocused.value) hintColor else textColor
                        )
                    }
                    innerTextField()
                }
            }
        },
        enabled = enabled,
        readOnly = readOnly,
    )
}