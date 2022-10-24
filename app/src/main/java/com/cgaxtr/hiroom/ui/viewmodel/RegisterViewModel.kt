package com.cgaxtr.hiroom.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cgaxtr.hiroom.domain.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val RegisterUseCase: RegisterUseCase): ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _firstSurname = MutableLiveData<String>()
    val firstSurname: LiveData<String> = _firstSurname

    private val _secondSurname = MutableLiveData<String>()
    val secondSurname: LiveData<String> = _secondSurname

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onTextChanged(name: String, firstSurname: String, secondSurname: String, email: String, password: String){
        _name.value = name
        _firstSurname.value = firstSurname
        _secondSurname.value = secondSurname
        _email.value = email
        _password.value = password

    }

}