package com.cgaxtr.hiroom.domain

import com.cgaxtr.hiroom.data.pref.DataStoreRepository
import javax.inject.Inject

class SaveOnboardingStateUseCase @Inject constructor(private val repository: DataStoreRepository) {

    suspend operator fun invoke(status: Boolean) {
        repository.saveOnboardingFinished(status)
    }
}