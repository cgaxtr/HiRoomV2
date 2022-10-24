package com.cgaxtr.hiroom.data.remote

import javax.inject.Inject


class UserRepository @Inject constructor(){

    suspend fun login(email: String, password : String): Boolean {

        

        return true
    }
}