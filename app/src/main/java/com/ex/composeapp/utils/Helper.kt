package com.ex.composeapp.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

object Helper {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message,Toast.LENGTH_SHORT).show()
    }
    fun appLogger(message: String, tag: String = "TAG") {
        Log.e(tag, message)
    }

}