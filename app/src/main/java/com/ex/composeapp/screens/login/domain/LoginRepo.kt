package com.ex.composeapp.screens.login.domain

import com.ex.composeapp.screens.login.data.LoginResponse

/**
 *  if used LoginRepoImpl then need to class into interface
 */
interface LoginRepo {

   /* suspend fun login(email: String, password: String): Result<LoginResponse> {
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
    }*/
   suspend fun login(email: String, password: String): Result<LoginResponse>



}