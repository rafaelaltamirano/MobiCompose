package com.example.mobicomposeapp.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobicomposeapp.ui.screen.MainModel
import com.example.mobicomposeapp.ui.screen.login.LoginModel
import com.example.mobicomposeapp.ui.screen.login.LoginScreen
import com.example.mobicomposeapp.ui.screen.splash.SplashScreen

@Composable
fun PublicRouter(navController: NavHostController, mainModel: MainModel = viewModel()) {

    NavHost(
        navController = navController,
        startDestination = if (mainModel.state.showSplash) PublicRouterDir.SPLASH.route else PublicRouterDir.LOGIN.route
    ) {

            composable(PublicRouterDir.SPLASH.route) { SplashScreen() }
            composable(PublicRouterDir.LOGIN.route) {
                val model = hiltViewModel<LoginModel>()
                LoginScreen(
                    model = model,
                    mainModel = mainModel,
                    navController = navController
                )
            }
    }

}