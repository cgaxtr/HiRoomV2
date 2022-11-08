package com.cgaxtr.hiroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgaxtr.hiroom.domain.SaveOnboardingStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val useCase: SaveOnboardingStateUseCase): ViewModel() {

    fun completed(status: Boolean){
        viewModelScope.launch {
            useCase.invoke(status)
        }
    }
}