package com.devocean.feature.main.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devocean.core.designsystem.component.button.TextButton
import com.devocean.core.designsystem.component.textfield.SpotBasicTextField
import com.devocean.core.designsystem.theme.SpotLightGray
import com.devocean.core.extension.noRippleClickable
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
        Column(
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .background(
                    color = SpotLightGray,
                    shape = RoundedCornerShape(20.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.plus_dialog_title),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, bottom = 30.dp),
                textAlign = TextAlign.Center
            )
            SpotBasicTextField(
                hint = stringResource(id = R.string.plus_dialog_url),
                modifier = Modifier
                    .padding(
                        bottom = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
                    .fillMaxWidth()
            )
            TextButton(
                onButtonClick = {
                    // TODO: onSummaryClick()
                },
                text = stringResource(id = R.string.plus_dialog_summary),
                modifier = Modifier
                    .padding(
                        bottom = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
                    .fillMaxWidth()
                    .noRippleClickable {
                        onDismissRequest()
                    },
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}