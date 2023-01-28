package com.cgaxtr.hiroom.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.cgaxtr.hiroom.ui.screens.LoginScreen
import com.cgaxtr.hiroom.ui.screens.RegisterScreen
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel
import com.cgaxtr.hiroom.ui.viewmodel.RegisterViewModel


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {

        composable(AuthScreen.Login.route){
            LoginScreen(viewModel = hiltViewModel<LoginViewModel>(), navController = navController)
        }

        composable(AuthScreen.SignUp.route){
            RegisterScreen(viewModel = hiltViewModel<RegisterViewModel>(), navController = navController)
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "login_screen")
    object SignUp : AuthScreen(route = "sign_up_screen")
    //object Forgot : AuthScreen(route = "FORGOT")
}