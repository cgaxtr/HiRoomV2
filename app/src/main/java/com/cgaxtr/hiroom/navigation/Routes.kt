package com.cgaxtr.hiroom.navigation

sealed class Screen(val route: String) {
    object Login : Screen(route = "login_screen")
    object Register : Screen(route = "register_screen")
    object Onboarding : Screen(route = "onboarding_screen")
    object Main : Screen(route = "main_screen")
}
