package com.ex.composeapp.screens.login.presentation

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex.composeapp.screens.login.data.LoginResponse
import com.ex.composeapp.screens.login.domain.LoginRepo
import com.ex.composeapp.screens.login.domain.LoginRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepo: LoginRepo) : ViewModel() {
    private val _isFetching = MutableStateFlow(false)
    val isFetching = _isFetching.asStateFlow()
    var state by mutableStateOf(LoginRequest("",""))
        private set
    var errorMessage by mutableStateOf("")
        private set
    var loginRes by mutableStateOf(LoginResponse())
        private set

    fun onEmailChange(value: String) {
        state = state.copy(email = value)
    }

    fun onPasswordChange(value: String) {
        state = state.copy(password = value)
    }

    fun login() {
        val emailError = when {
            state.email.isBlank() -> "Email cannot be empty"
            !Patterns.EMAIL_ADDRESS.matcher(state.email).matches() -> "Enter a valid email address"
            else -> null
        }
        val passwordError = if (state.password.isBlank()) "Password cannot be empty" else null
        if (emailError != null) {
            errorMessage = emailError
            return
        }else if (passwordError != null){
            errorMessage =  passwordError
            return
        }

        viewModelScope.launch {
            _isFetching.value=true
            val result = loginRepo.login(state.email, state.password.toString())
             result.fold(
                onSuccess = {
                    it?.let {
                        loginRes.copy(access_token =it.access_token,refresh_token=it.refresh_token )
                    }
                    _isFetching.value=false
                },
                onFailure = {
                    errorMessage=it.message.toString()
                    _isFetching.value=false
                }
            )
        }
    }


}