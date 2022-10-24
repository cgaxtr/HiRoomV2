package com.cgaxtr.hiroom.ui.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaxtr.hiroom.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    private companion object {
        const val MIN_PASSWORD_LENGTH = 8
    }

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _navigateToMain = MutableLiveData(false)
    val navigateToMain: LiveData<Boolean> = _navigateToMain

    private val _showError = MutableLiveData(false)
    val showError : LiveData<Boolean> = _showError

    fun onTextChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun doLogin() {
        if (isValidEmail(_email.value!!) && isValidPassword(_password.value!!)){
            viewModelScope.launch {
                val loggedIn = loginUseCase(_email.value!!, _password.value!!)
                if(loggedIn)
                    _navigateToMain.postValue(true)
                else
                    _showError.postValue(true)
            }
        }
    }

    private fun isValidEmail(email: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()


    private fun isValidPassword(password: String): Boolean = password.length >= MIN_PASSWORD_LENGTH
}