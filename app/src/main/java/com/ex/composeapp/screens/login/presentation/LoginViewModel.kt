package com.ex.composeapp.screens.login.presentation

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex.composeapp.screens.login.domain.LoginState
import com.ex.composeapp.screens.login.domain.LoginRepo
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepo: LoginRepo) : ViewModel() {
    var state by mutableStateOf(LoginState())
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
            state = state.copy(error = emailError)
            return
        }else if (passwordError != null){
            state = state.copy(error = passwordError)
            return
        }
       /* viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            val result = loginRepo.login(state.email, state.password)
            state = result.fold(
                onSuccess = { state.copy(isLoading = false, success = true) },
                onFailure = { state.copy(isLoading = false, error = it.message) }
            )
        }*/
    }


}