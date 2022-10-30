package com.example.mobicomposeapp.ui.screen

import com.example.domain.model.Login

data class MainState(
    val scope: String?= null,
    val login: Login? = null,
    val showSplash: Boolean = true,
    )