package com.cgaxtr.hiroom.domain

import com.cgaxtr.hiroom.data.pref.DataStoreRepository
import javax.inject.Inject

class LoadOnboardingStateUseCase @Inject constructor(private val repository: DataStoreRepository) {

    operator fun invoke() = repository.loadOnboardingFinished()
}