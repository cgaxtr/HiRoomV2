package com.cgaxtr.hiroom.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cgaxtr.hiroom.R
import com.cgaxtr.hiroom.navigation.AuthScreen
import com.cgaxtr.hiroom.navigation.MainScreen
import com.cgaxtr.hiroom.navigation.Screen
import com.cgaxtr.hiroom.ui.components.EmailField
import com.cgaxtr.hiroom.ui.components.Footer
import com.cgaxtr.hiroom.ui.components.PasswordField
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel


@Preview(showSystemUi = true)
@Composable
fun PreviewLogin() {
    val viewModel: LoginViewModel = hiltViewModel()
    val navController = NavHostController(LocalContext.current)
    LoginScreen(viewModel, navController)
}


@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0, 200, 200),
                        Color(250, 0, 250)
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
            .padding(20.dp)
    ) {
        Body(Modifier.align(Alignment.Center), viewModel, navController)
        Footer(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            id = R.string.login_sing_up,
            destination = AuthScreen.SignUp.route
        )
    }
}

@Composable
fun Body(modifier: Modifier, viewModel: LoginViewModel, navController: NavHostController) {

    val email: String by viewModel.email.observeAsState("")
    val password: String by viewModel.password.observeAsState("")

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(40.dp))
        EmailField(email) {
            viewModel.onTextChanged(it, password)
        }
        Spacer(modifier = modifier.height(4.dp))
        PasswordField(password) {
            viewModel.onTextChanged(email, it)
        }
        Spacer(modifier = modifier.height(8.dp))
        ForgottenPassword(Modifier.align(Alignment.End))
        Spacer(modifier = modifier.height(20.dp))
        LoginButton(navController = navController) {
            viewModel.doLogin()
        }
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.login_description_logo)
    )
}


@Composable
fun ForgottenPassword(modifier: Modifier) {
    Text(text = stringResource(id = R.string.login_forgotten_password),
        color = Color.White,
        modifier = modifier.clickable { }
    )
}

@Composable
fun LoginButton(navController: NavHostController, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(50),
        onClick = {
            onClick()
            navController.navigate(MainScreen.HomeScreen.route)
        }) {
        Text(text = stringResource(id = R.string.login_button))
    }
}