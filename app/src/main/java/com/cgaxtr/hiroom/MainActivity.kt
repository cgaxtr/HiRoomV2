package com.cgaxtr.hiroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cgaxtr.hiroom.navigation.Screen
import com.cgaxtr.hiroom.navigation.SetupNavGraph
import com.cgaxtr.hiroom.ui.screens.LoginScreen
import com.cgaxtr.hiroom.ui.theme.HiRoomTheme
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel
import com.cgaxtr.hiroom.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel : SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            splashViewModel.isLoading.value!!
        }

        setContent {
            HiRoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController, Screen.Onboarding.route)
                }
            }
        }
    }
}