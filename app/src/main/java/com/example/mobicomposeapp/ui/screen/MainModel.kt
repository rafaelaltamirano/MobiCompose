package com.example.mobicomposeapp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Login
import com.example.usecase.MainCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor(
    private val mainCase: MainCase
) : ViewModelWithStatus() {

    init {
        viewModelScope.launch {
            delay(2000)
            setShowSplash(false)
        }
    }

    var state by mutableStateOf(MainState())
        private set
    fun setLogin(login: Login) {
        state = state.copy(login = login)
    }

    private fun setShowSplash(showSplash: Boolean) {
        state = state.copy(showSplash = showSplash)
    }

}
