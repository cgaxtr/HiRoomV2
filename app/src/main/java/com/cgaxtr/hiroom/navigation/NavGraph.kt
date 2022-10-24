package com.cgaxtr.hiroom.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cgaxtr.hiroom.ui.screens.LoginScreen
import com.cgaxtr.hiroom.ui.screens.MainScreen
import com.cgaxtr.hiroom.ui.screens.OnboardingScreen
import com.cgaxtr.hiroom.ui.screens.RegisterScreen
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel
import com.cgaxtr.hiroom.ui.viewmodel.OnboardingViewModel
import com.cgaxtr.hiroom.ui.viewmodel.RegisterViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, start: String
) {
   NavHost(navController = navController, startDestination = start){
       composable(Screen.Login.route){
           val viewModel = hiltViewModel<LoginViewModel>()
           LoginScreen(viewModel = viewModel, navController = navController)
       }

       composable(Screen.Register.route){
           val viewModel = hiltViewModel<RegisterViewModel>()
           RegisterScreen(viewModel = viewModel, navController = navController)
       }

       composable(Screen.Main.route){
           MainScreen()
       }

       composable(Screen.Onboarding.route){
           val viewModel = hiltViewModel<OnboardingViewModel>()
           OnboardingScreen(viewModel = viewModel, navController = navController)
       }
   }
}