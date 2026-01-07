package com.ex.composeapp.networks

import com.ex.composeapp.screens.login.data.LoginResponse
import com.ex.composeapp.screens.login.domain.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

}