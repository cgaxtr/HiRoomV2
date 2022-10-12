package com.cgaxtr.hiroom.ui.screens

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cgaxtr.hiroom.R
import com.cgaxtr.hiroom.ui.viewmodel.LoginViewModel

/*
@Preview(showSystemUi = true)
@Composable
fun PreviewLogin() {
    LoginScreen()
}
*/

@Composable
fun LoginScreen(viewModel: LoginViewModel) {

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
        Body(Modifier.align(Alignment.Center), viewModel)
        Footer(Modifier.align(Alignment.BottomCenter))

    }
}

@Composable
fun Body(modifier: Modifier, viewModel: LoginViewModel) {

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
        LoginButton {
            viewModel.doLogin()
        }
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        //todo change logo
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = stringResource(id = R.string.login_description_logo)
    )
}

@Composable
fun EmailField(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50),
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(
                text = stringResource(id = R.string.login_email),
                color = Color.White
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
    )
}

@Composable
fun PasswordField(password: String, onTextChanged: (String) -> Unit) {
    var isVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50),
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(
                text = stringResource(id = R.string.login_password),
                color = Color.White
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
        trailingIcon = {
            val image = if (isVisible) {
                Icons.Rounded.VisibilityOff
            } else {
                Icons.Rounded.Visibility
            }
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(image, stringResource(id = R.string.login_hide_show), tint = Color.White)
            }
        },
        visualTransformation = if (isVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }

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
fun LoginButton(onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(50),
        onClick = { onClick() }) {
        Text(text = stringResource(id = R.string.login_button))
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Text(
        color = Color.White,
        text = stringResource(id = R.string.login_sing_up),
        modifier = modifier.clickable {},
    )
}