package com.example.mobicomposeapp.ui.screen.login

import com.example.domain.entities.Login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val loading: Boolean = false,
    val login: Boolean? = null,
)