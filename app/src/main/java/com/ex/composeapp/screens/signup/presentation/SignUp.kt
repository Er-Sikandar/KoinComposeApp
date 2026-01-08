package com.ex.composeapp.screens.signup.presentation

import android.view.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SignUp(onBack:()->Unit){
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
        ) {
            Button(
                onClick = {
                    onBack()
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = true
            ) {
                Text( "Back")
            }
        }
    }
}