package com.cgaxtr.hiroom.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cgaxtr.hiroom.R
import com.cgaxtr.hiroom.navigation.AuthScreen
import com.cgaxtr.hiroom.navigation.MainScreen
import com.cgaxtr.hiroom.navigation.Screen
import com.cgaxtr.hiroom.ui.components.EmailField
import com.cgaxtr.hiroom.ui.components.Footer
import com.cgaxtr.hiroom.ui.components.NameField
import com.cgaxtr.hiroom.ui.components.PasswordField
import com.cgaxtr.hiroom.ui.viewmodel.RegisterViewModel

@Preview
@Composable
fun RegisterPreview() {
    val registerViewModel : RegisterViewModel = hiltViewModel()
    val navController = NavHostController(LocalContext.current)
    RegisterScreen(registerViewModel, navController)
}

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, navController: NavHostController) {
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
            id = R.string.sing_up_login,
            destination = AuthScreen.Login.route
        )
    }
}

@Composable
fun RegisterHeader() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Looks like you're new here",
            color = Color.White,
        )
        Text(
            text = "Sing up now",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
    }
}

@Composable
fun Body(modifier: Modifier, viewModel: RegisterViewModel, navController: NavHostController) {
    Column(modifier = modifier) {
        val name: String by viewModel.name.observeAsState("")
        val email: String by viewModel.email.observeAsState("")
        val password: String by viewModel.password.observeAsState("")
        val firstSurname: String by viewModel.firstSurname.observeAsState("")
        val secondSurname: String by viewModel.secondSurname.observeAsState("")

        RegisterHeader()
        Spacer(modifier = Modifier.height(48.dp))
        NameField(name) {
            viewModel.onTextChanged(it, firstSurname, secondSurname, email, password)
        }
        Spacer(modifier = modifier.height(4.dp))
        Row(Modifier.fillMaxWidth()) {
            SurnameField(
                Modifier.weight(1f),
                firstSurname,
                RoundedCornerShape(50, 0, 0, 50)
            ) {
                viewModel.onTextChanged(name, it, secondSurname, email, password)
            }
            Spacer(modifier = Modifier.width(4.dp))
            SurnameField(
                Modifier.weight(1f),
                secondSurname,
                RoundedCornerShape(0, 50, 50, 0)
            ) {
                viewModel.onTextChanged(name, firstSurname, it, email, password)
            }
        }
        Spacer(modifier = modifier.height(4.dp))
        EmailField(email = email) {
            viewModel.onTextChanged(name, firstSurname, secondSurname, it, password)
        }
        Spacer(modifier = modifier.height(4.dp))
        PasswordField(password = password) {
            viewModel.onTextChanged(name, firstSurname, secondSurname, email, it)
        }
        Spacer(modifier = modifier.height(20.dp))
        RegisterButton(navController = navController) {
            //TODO
        }

    }
}

@Composable
fun SurnameField(
    modifier: Modifier,
    surname: String,
    shape: RoundedCornerShape,
    onTextChanged: (String) -> Unit
) {
    TextField(
        value = surname,
        onValueChange = { onTextChanged(it) },
        modifier = modifier,
        shape = shape,
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(
                text = "Surname",
                color = Color.White
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
    )
}

@Composable
fun RegisterButton(navController: NavHostController, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(50),
        onClick = {
            onClick()
            //Check before navigate
            navController.navigate(MainScreen.HomeScreen.route)
        }) {
        Text(text = stringResource(id = R.string.sing_up_sing_up))
    }
}
