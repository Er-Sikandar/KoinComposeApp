package com.ex.composeapp.screens.splash

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ex.composeapp.utils.Const
import com.ex.composeapp.R
import com.ex.composeapp.ui.theme.App_Color
import com.ex.composeapp.utils.EncPrefs
import com.ex.composeapp.utils.Helper.appLogger
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

@Composable
fun SplashScreen(onNavigateToLogin: () -> Unit,
                 onNavigateToHome: () -> Unit) {
    val encPrefs: EncPrefs = koinInject()
    LaunchedEffect(key1 = true) {
        delay(Const.SPLASH_TIME.toLong())
        val isUserLoggedIn = encPrefs.getPrefsBoolean(Const.IS_LOGIN)
        if (isUserLoggedIn) {
            onNavigateToHome()
            appLogger("SplashGo:>> Home")
        }else{
            onNavigateToLogin()
            appLogger("SplashGo Else:>> ")
        }
     }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Logo",
                    modifier = Modifier.size(150.dp)
                )
            }
}
