package com.cgaxtr.hiroom.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {


    private val _email = MutableLiveData<String>("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>("")
    val password: LiveData<String> = _password

    fun onTextChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun doLogin() {

    }

}