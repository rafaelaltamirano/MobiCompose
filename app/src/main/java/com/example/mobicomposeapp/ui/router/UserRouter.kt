package com.example.mobicomposeapp.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobicomposeapp.ui.router.UserRouterDir.HOME
import com.example.mobicomposeapp.ui.screen.MainModel
import com.example.mobicomposeapp.ui.screen.home.HomeModel
import com.example.mobicomposeapp.ui.screen.home.HomeScreen


@Composable
fun UserRouter(navController: NavHostController, mainModel: MainModel = viewModel()) {

    val homeModel = hiltViewModel<HomeModel>()

    NavHost(navController = navController, startDestination = HOME.route) {
        composable(HOME.route) {
            HomeScreen(homeModel,navController)
        }
    }
}
