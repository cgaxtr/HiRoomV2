package com.cgaxtr.hiroom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cgaxtr.hiroom.ui.screens.LoginScreen
import com.cgaxtr.hiroom.ui.screens.MainScreen
import com.cgaxtr.hiroom.ui.screens.RegisterScreen
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel
import com.cgaxtr.hiroom.ui.viewmodel.RegisterViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, start: String
) {
   NavHost(navController = navController, startDestination = start){
       composable(Screen.Login.route){
           LoginScreen(viewModel = LoginViewModel(), navController)
       }

       composable(Screen.Register.route){
           RegisterScreen(viewModel = RegisterViewModel(), navController)
       }

       composable(Screen.Main.route){
           MainScreen()
       }
   }
}