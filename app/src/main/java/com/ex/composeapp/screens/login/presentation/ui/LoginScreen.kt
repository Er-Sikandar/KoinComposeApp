package com.ex.composeapp.screens.login.presentation.ui

import android.text.TextUtils
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*
import com.ex.composeapp.screens.login.presentation.LoginViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ex.composeapp.utils.Helper.appLogger
import com.ex.composeapp.utils.Helper.showToast

@Composable
fun LoginScreen(modifier: Modifier,viewModel: LoginViewModel = koinViewModel()) {
    val savedToken = viewModel.savedToken
    val context = LocalContext.current
    LaunchedEffect(viewModel.errorMessage,savedToken) {
        if (!TextUtils.isEmpty(viewModel.errorMessage)){
            showToast(context,viewModel.errorMessage)
            appLogger(viewModel.errorMessage)
        }
        if (savedToken.isNotEmpty()){
            appLogger(savedToken)
        }
    }
    Column(
        modifier = modifier.fillMaxSize().padding(12.dp),
    ) {

        Text("Login", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.state.email.toString(),
            onValueChange = viewModel::onEmailChange,
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = viewModel.state.password.toString(),
            onValueChange = viewModel::onPasswordChange,
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { viewModel.login() },
            modifier = Modifier.fillMaxWidth(),
            enabled = !viewModel.isFetching.collectAsState().value
        ) {
            Text(if (viewModel.isFetching.collectAsState().value) "Logging in..." else "Login")
        }

    }
}
