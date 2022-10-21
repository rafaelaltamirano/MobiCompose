package com.example.mobicomposeapp.ui.router

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobicomposeapp.ui.router.RouterDir.*
import com.example.mobicomposeapp.ui.screen.MainModel
import com.example.mobicomposeapp.ui.screen.login.LoginModel
import com.example.mobicomposeapp.ui.screen.login.LoginScreen
import com.example.mobicomposeapp.ui.screen.splash.SplashScreen

@Composable
fun Router(mainModel: MainModel) {

    val navController = rememberNavController()

    val state = mainModel.state

    val login = state.login

    NavHost(
        navController = navController,
        startDestination = if (mainModel.state.showSplash) SPLASH.route else LOGIN.route
    ) {
        composable(SPLASH.route) { SplashScreen() }
        composable(LOGIN.route) {
            val model = hiltViewModel<LoginModel>()
            LoginScreen(
                model = model,
                mainModel = mainModel,
                navController = navController
            )
        }
    }
}