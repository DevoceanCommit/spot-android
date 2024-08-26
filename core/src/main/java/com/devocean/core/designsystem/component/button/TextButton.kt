package com.devocean.core.designsystem.component.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devocean.core.util.NoRippleTheme

@Composable
fun TextButton(
    onButtonClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    paddingVertical: Dp = 0.dp,
) {
    val interactionSource = remember { MutableInteractionSource() }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            modifier = modifier,
            contentPadding = PaddingValues(paddingVertical),
            interactionSource = interactionSource,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF9623E),
                contentColor = Color.Black
            ),
            shape = CircleShape,
            onClick = { onButtonClick() }
        ) {
            Text(
                text = text,
                color = textColor
            )
        }
    }
}
