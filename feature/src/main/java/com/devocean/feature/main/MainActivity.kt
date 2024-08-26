package com.devocean.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.feature.main.dialog.PlusDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevoceanSpotTheme {
                val context = LocalContext.current
                val lifecycleOwner = LocalLifecycleOwner.current

                val viewModel: MainViewModel = hiltViewModel()
                val navigator: MainNavigator = rememberMainNavigator()

                val state by viewModel.state.collectAsStateWithLifecycle(lifecycleOwner = lifecycleOwner)

                when (state.showPlusDialog) {
                    true -> PlusDialog(onDismissRequest = { viewModel.fetchShowDialog(false) })
                    else -> {}
                }

                MainScreen(
                    navigator = navigator,
                    onPlusDialogClick = { viewModel.fetchShowDialog(true) }
                )
            }
        }
    }
}
