package com.cgaxtr.hiroom.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.cgaxtr.hiroom.navigation.HomeNavGraph


@Preview(showSystemUi = true)
@Composable
fun PreviewMain() {
    MainScreen()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        //TODO PaddingValues
        HomeNavGraph(navController)
    }
}

@Composable
fun BottomBar(navController: NavController) {
    //TODD change index
    var index by remember { mutableStateOf(0) }
    BottomNavigation() {

        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home"
            )
        })

        BottomNavigationItem(selected = index == 1, onClick = { index = 1; }, icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Favourite"
            )
        })

        BottomNavigationItem(selected = index == 2, onClick = { index = 2; }, icon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile"
            )
        })

    }
}