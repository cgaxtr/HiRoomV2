package com.cgaxtr.hiroom.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.cgaxtr.hiroom.R

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
fun NameField(name: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50),
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(
                text = stringResource(id = R.string.sing_up_name),
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
