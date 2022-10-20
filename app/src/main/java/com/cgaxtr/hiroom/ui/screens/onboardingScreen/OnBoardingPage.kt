package com.cgaxtr.hiroom.ui.screens.onboardingScreen

import androidx.annotation.DrawableRes
import com.cgaxtr.hiroom.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        //todo change image
        image = R.drawable.ic_launcher_background,
        title = "Publish",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Second : OnBoardingPage(
        //todo change image
        image = R.drawable.ic_launcher_background,
        title = "Search",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Third : OnBoardingPage(
        //todo change image
        image = R.drawable.ic_launcher_background,
        title = "Contact",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}