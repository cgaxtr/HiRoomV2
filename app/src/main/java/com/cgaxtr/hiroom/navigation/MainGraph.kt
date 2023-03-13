package com.cgaxtr.hiroom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cgaxtr.hiroom.ui.screens.HomeScreen
import com.cgaxtr.hiroom.ui.screens.MainScreen

@Composable
fun HomeNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.MAIN,
        startDestination = MainScreen.HomeScreen.route
    ) {
        composable(MainScreen.HomeScreen.route) {
            HomeScreen()
        }

        composable(MainScreen.ProfileScreen.route){
            //TODO
        }

        composable(MainScreen.FavouriteScreen.route){
            //TODO
        }
    }
}

sealed class MainScreen(val route: String) {
    object HomeScreen : MainScreen(route = "home_screen")
    object ProfileScreen : MainScreen(route = "profile_screen")
    object FavouriteScreen : MainScreen(route = "favourite_screen")

}