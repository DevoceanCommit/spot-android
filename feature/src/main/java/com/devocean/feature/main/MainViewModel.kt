package com.devocean.feature.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private var _state: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val state get() = _state.asStateFlow()

    fun fetchShowDialog(visibility: Boolean) {
        _state.update { state ->
            state.copy(
                showPlusDialog = visibility
            )
        }
    }
}