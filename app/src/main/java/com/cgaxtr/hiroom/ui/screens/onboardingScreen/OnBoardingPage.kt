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
        image = R.drawable.publish,
        title = "Post",
        description = "Post your own ad in a few simple steps."
    )

    object Second : OnBoardingPage(
        image = R.drawable.search,
        title = "Search",
        description = "Search and discover your dream house."
    )

    object Third : OnBoardingPage(
        image = R.drawable.contact,
        title = "Contact",
        description = "Contact directly with the ad owner."
    )
}