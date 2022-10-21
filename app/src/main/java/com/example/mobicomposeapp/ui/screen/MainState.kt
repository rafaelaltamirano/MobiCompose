package com.example.mobicomposeapp.ui.screen

import com.example.domain.entities.Login

data class MainState(
    val scope: String?= null,
    val login: Login? = null
    )