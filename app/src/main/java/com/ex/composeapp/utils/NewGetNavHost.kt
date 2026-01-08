package com.ex.composeapp.utils

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.ex.composeapp.screens.dashboard.presentation.ui.DashboardScreen
import com.ex.composeapp.screens.login.presentation.LoginViewModel
import com.ex.composeapp.screens.login.presentation.ui.LoginScreen
import com.ex.composeapp.screens.signup.presentation.SignUp
import com.ex.composeapp.screens.splash.SplashScreen
import com.ex.composeapp.utils.Destinations.DASHBOARD_ROUTE
import com.ex.composeapp.utils.Destinations.LOGIN_ROUTE
import com.ex.composeapp.utils.Destinations.SIGNUP_ROUTE
import com.ex.composeapp.utils.Destinations.SPLASH_ROUTE
import org.koin.androidx.compose.koinViewModel

object Destinations {
    const val SPLASH_ROUTE = "splash"
    const val LOGIN_ROUTE = "login"
    const val SIGNUP_ROUTE = "sign_up"
    const val DASHBOARD_ROUTE = "dashboard"
    const val HOME_TO_HOME_ROUTE = "home_to_home"
    const val PROFILE_ROUTE = "profile"
    const val SETTINGS_ROUTE = "settings"
    const val SLICE_MENU_ROUTE = "slice_menu"
    const val NOTIFICATIONS_ROUTE = "notifications"
    const val WEBVIEW_ROUTE = "webview?url={url}&type={type}"

}
@Composable
fun NewGetNavHost(modifier: Modifier,navController: NavHostController = rememberNavController()) {
    NavHost(modifier = modifier,navController = navController, startDestination = SPLASH_ROUTE) {
        composable(SPLASH_ROUTE) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(LOGIN_ROUTE) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(DASHBOARD_ROUTE) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                },
            )
        }
        composable(LOGIN_ROUTE) {
           val viewModel: LoginViewModel = koinViewModel()
            LoginScreen(
                onNavigateSignUp = {
                    navController.navigate(SIGNUP_ROUTE)
                },
                onNavigateHome = {
                    navController.navigate(DASHBOARD_ROUTE) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                },
                viewModel
            )
        }
        composable(SIGNUP_ROUTE) {
            SignUp(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(DASHBOARD_ROUTE) {
            val context = LocalContext.current
            val activity = context as? Activity
            DashboardScreen(
                onNavigateHomeToLogin = {
                    navController.navigate(LOGIN_ROUTE) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onExitApp = {
                    activity?.finish()
                }
            )
        }



    }

}