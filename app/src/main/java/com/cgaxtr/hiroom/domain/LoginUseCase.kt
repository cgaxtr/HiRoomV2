package com.cgaxtr.hiroom.domain

import com.cgaxtr.hiroom.data.remote.UserRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.login(user, password)
    }
}