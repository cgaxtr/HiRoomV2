package com.cgaxtr.hiroom.ui

import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Composable
fun RegisterScreen(){

    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable{ mutableStateOf("")}
    var email by rememberSaveable{ mutableStateOf("")}
    var password by rememberSaveable{ mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Email") }
        )
        TextField(
            value = surname,
            onValueChange = { surname = it },
            label = { Text("Email") }
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Email") }
        )
        
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Register")
        }

    }
}

@Preview(name = "RegisterScreen", )
@Composable
fun PreviewRegisterScreen(){
    RegisterScreen()
}