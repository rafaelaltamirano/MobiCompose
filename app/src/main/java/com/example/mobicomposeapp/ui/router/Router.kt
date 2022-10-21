package com.example.mobicomposeapp.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobicomposeapp.ui.router.RouterDir.LOGIN
import com.example.mobicomposeapp.ui.screen.MainModel

@Composable
fun Router(mainModel: MainModel) {

    val navController = rememberNavController()

    val state = mainModel.state

    val login = state.login

    NavHost(
        navController = navController,
        startDestination = LOGIN.route
    ) {
        composable(LOGIN.route) {

        }
    }
}