package com.cgaxtr.hiroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(): ViewModel() {

    fun completed(){
        //Invoke usecase and store onboading screen was completed
    }
}