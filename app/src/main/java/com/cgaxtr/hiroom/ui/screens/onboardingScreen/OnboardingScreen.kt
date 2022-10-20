package com.cgaxtr.hiroom.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cgaxtr.hiroom.R
import com.cgaxtr.hiroom.navigation.Screen
import com.cgaxtr.hiroom.ui.screens.onboardingScreen.OnBoardingPage
import com.cgaxtr.hiroom.ui.viewmodel.OnboardingViewModel
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(viewModel: OnboardingViewModel, navController: NavHostController) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
        OnBoardingPage.Second
    )
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {
            Page(pages[it])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState
        )

        ConfirmButton(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            pagerState = pagerState,
            maxPages = pages.size
        ) {
            viewModel.completed()
            navController.popBackStack()
            navController.navigate(Screen.Login.route)
        }
    }
}

@Composable
fun Page(page: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            //text = onBoardingPage.title,
            text = page.title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = page.description,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ConfirmButton(modifier: Modifier, pagerState: PagerState, maxPages: Int, onClick: () -> Unit) {
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == maxPages - 1
        ) {
            OutlinedButton(
                onClick = { onClick() },
                modifier = modifier.padding(8.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "Finish"
                )

            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewOnboarding() {
    val viewModel = OnboardingViewModel()
    val navController = NavHostController(LocalContext.current)
    OnboardingScreen(viewModel, navController)
}