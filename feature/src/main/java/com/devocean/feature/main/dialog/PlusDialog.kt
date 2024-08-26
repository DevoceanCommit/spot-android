package com.devocean.feature.main.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devocean.core.designsystem.component.button.TextButton
import com.devocean.core.designsystem.component.textfield.SpotBasicTextField
import com.devocean.core.designsystem.theme.SpotLightGray
import com.devocean.feature.R

@Composable
fun PlusDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(
        usePlatformDefaultWidth = false,
        decorFitsSystemWindows = true,
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
    ),
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = properties,
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 27.dp)
                .background(
                    color = SpotLightGray,
                    shape = RoundedCornerShape(20.dp)
                ),
        ) {
            Text(text = stringResource(id = R.string.plus_dialog_title))
            SpotBasicTextField(hint = stringResource(id = R.string.plus_dialog_url))
            TextButton(
                onButtonClick = {
                    // TODO: onSummaryClick()
                },
                text = stringResource(id = R.string.plus_dialog_summary)
            )
        }
    }
}