package com.pathok.user.screens

import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Created by Shuvo on 07/13/2025.
 */
class SampleViewModel : ViewModel() {
    private val _state = MutableStateFlow(5)
    val state = _state.asStateFlow()
}