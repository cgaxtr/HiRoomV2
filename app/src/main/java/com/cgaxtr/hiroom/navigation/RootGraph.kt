package com.cgaxtr.hiroom.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cgaxtr.hiroom.ui.screens.MainScreen
import com.cgaxtr.hiroom.ui.screens.onboardingScreen.OnboardingScreen

@Composable
fun RootNavigationGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = startDestination) {

        authNavGraph(navController = navController)
        mainNavGraph(navController = navController)
        composable(route = Graph.ONBOARDING){
            OnboardingScreen(viewModel = hiltViewModel(), navController = navController)
        }
    }

}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val MAIN = "main_graph"
    const val ONBOARDING = "onboarding_screen"
}