package com.cgaxtr.hiroom.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview(showSystemUi = true)
@Composable
fun PreviewMain() {
    MainScreen()
}

@Composable
fun MainScreen() {
    Scaffold(bottomBar = {
        BottomBar()

    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)){

        }
    }
}

@Composable
fun BottomBar() {
    BottomNavigation() {
        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = ""
            )
        })
        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = ""
            )
        })
    }
}