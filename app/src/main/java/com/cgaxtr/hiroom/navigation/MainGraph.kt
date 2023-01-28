package com.cgaxtr.hiroom.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cgaxtr.hiroom.ui.screens.LoginScreen
import com.cgaxtr.hiroom.ui.screens.MainScreen
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel


fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.MAIN,
        startDestination = MainScreen.HomeScreen.route
    ) {

        composable(MainScreen.HomeScreen.route){
            MainScreen()
        }
    }
}

sealed class MainScreen(val route: String) {
    object HomeScreen : MainScreen(route = "home_screen")
}