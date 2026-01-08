package com.ex.composeapp.screens.dashboard.presentation.ui

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ex.composeapp.utils.EncPrefs
import com.ex.composeapp.utils.Helper.showToast
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

@Composable
fun DashboardScreen(onNavigateHomeToLogin:()-> Unit,onExitApp:()-> Unit) {
    val context: Context = LocalContext.current
    var doubleBackToExitPressedOnce by remember { mutableStateOf(false) }
    val navController = rememberNavController()
    val encPrefs: EncPrefs = koinInject()
    var showLogoutDialog by remember { mutableStateOf(false) }
    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Logout") },
            text = { Text("Are you sure you want to logout?") },
            confirmButton = {
                Button(onClick = {
                    encPrefs.clearAll()
                    onNavigateHomeToLogin()
                    showLogoutDialog = false
                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(onClick = { showLogoutDialog = false }) {
                    Text("No")
                }
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(12.dp),
    ) {
        Button(
            onClick = {
                showLogoutDialog=true
                  },
            modifier = Modifier.fillMaxWidth(),
            enabled = true
        ) {
            Text( "Logout")
        }
    }


    /**
     * Double click back here..
     */
    BackHandler {
        if (doubleBackToExitPressedOnce) {
            onExitApp()
        } else {
            doubleBackToExitPressedOnce = true
            showToast(context,"Press back again to exit")
        }
    }
    LaunchedEffect(doubleBackToExitPressedOnce) {
        if (doubleBackToExitPressedOnce) {
            delay(2000)
            doubleBackToExitPressedOnce = false
        }
    }
}