package com.example.mobicomposeapp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.domain.entities.Login
import com.example.usecase.MainCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor(
    private val mainCase: MainCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(MainState())
        private set

    fun setLogin(login: Login) {
        state = state.copy(login = login)
    }
}
