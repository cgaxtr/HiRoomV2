package com.cgaxtr.hiroom.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaxtr.hiroom.domain.LoadOnboardingStateUseCase
import com.cgaxtr.hiroom.navigation.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val useCase: LoadOnboardingStateUseCase): ViewModel() {

    private val _isLoading = MutableLiveData(true)
    val isLoading : LiveData<Boolean> = _isLoading

    private val _destination = MutableLiveData<String>(Graph.ONBOARDING)
    val destination : LiveData<String> = _destination

    init {
        viewModelScope.launch(Dispatchers.IO) {

            useCase.invoke().collect{
                if(it){
                    _destination.postValue(Graph.AUTH)
                    Log.d("SPLASH_VIEW_MODEL","Login")
                }else{
                    _destination.postValue(Graph.ONBOARDING)
                    Log.d("SPLASH_VIEW_MODEL","Onboarding")
                }
                _isLoading.postValue(false)
            }
        }
    }
}