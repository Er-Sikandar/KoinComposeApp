package com.ex.composeapp.screens.login.data

import com.ex.composeapp.networks.ApiService
import com.ex.composeapp.screens.login.domain.LoginRequest
import com.ex.composeapp.screens.login.domain.LoginRepo

class LoginRepoImpl(private val api: ApiService): LoginRepo {
    override suspend fun login(email: String, password: String): Result<LoginResponse> {
        return try {
            val response = api.login(LoginRequest(email, password))
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Invalid credentials"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}