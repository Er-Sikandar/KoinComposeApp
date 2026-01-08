package com.ex.composeapp.screens.login.presentation.ui

import android.text.TextUtils
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*
import com.ex.composeapp.screens.login.presentation.LoginViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.ex.composeapp.ui.theme.App_Color
import com.ex.composeapp.utils.Helper.appLogger
import com.ex.composeapp.utils.Helper.showToast

@Composable
fun LoginScreen(onNavigateSignUp:()-> Unit,onNavigateHome:()-> Unit, viewModel: LoginViewModel) {
    val savedToken = viewModel.savedToken
    val context = LocalContext.current
    val loginSuccess = viewModel.loginSuccess.collectAsState().value

    LaunchedEffect(viewModel.errorMessage,savedToken) {
        if (!TextUtils.isEmpty(viewModel.errorMessage)){
            showToast(context,viewModel.errorMessage)
            appLogger(viewModel.errorMessage)
        }
        if (loginSuccess) {
            appLogger(savedToken)
            onNavigateHome()
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Surface(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            Column(
                modifier = Modifier.fillMaxSize().padding(12.dp),
            ) {

                Text("Login", fontSize = 28.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    value = viewModel.state.email,
                    onValueChange = viewModel::onEmailChange,
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = viewModel.state.password,
                    onValueChange = viewModel::onPasswordChange,
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(35.dp))

                Button(
                    onClick = { viewModel.login() },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !viewModel.isFetching.collectAsState().value
                ) {
                    Text(if (viewModel.isFetching.collectAsState().value) "Logging in..." else "Login")
                }
                Spacer(Modifier.height(20.dp))
                Text(
                    "SignUp",
                    fontSize = 14.sp, color = App_Color,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().clickable {
                        onNavigateSignUp()
                    }
                )

            }
        }
    }
}
