package com.cgaxtr.hiroom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@Composable
fun Footer(modifier: Modifier, navController: NavHostController, id: Int, destination: String) {
    Text(
        color = Color.White,
        text = stringResource(id),
        modifier = modifier.clickable {navController.navigate(destination)},
    )
}