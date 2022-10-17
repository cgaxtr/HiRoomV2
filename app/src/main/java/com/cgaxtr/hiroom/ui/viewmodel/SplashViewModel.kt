package com.cgaxtr.hiroom.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private val _isLoading = MutableLiveData(true)
    val isLoading : LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //TODO check login and first time use
            Thread.sleep(1000)
            _isLoading.postValue(false)
        }
    }

}