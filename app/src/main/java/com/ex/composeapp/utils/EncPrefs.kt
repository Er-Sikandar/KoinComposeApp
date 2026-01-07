package com.ex.composeapp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.MasterKeys

class EncPrefs(context: Context) {
    private val PREFS_NAME = "Koin_Comp_Enc_Prefs"
    private val sharedPreferences: SharedPreferences by lazy {
        val masterKeyAlias = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        EncryptedSharedPreferences.create(context, PREFS_NAME, masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
    private val editor: SharedPreferences.Editor by lazy { sharedPreferences.edit() }

    fun setPrefsString(key: String, value: String) {
        editor.putString(key, value).apply()
    }
    fun getPrefsString(key: String, default: String = ""): String {
        return sharedPreferences.getString(key, default) ?: default
    }

    fun setPrefsInt(key: String, value: Int) {
        editor.putInt(key, value).apply()
    }

    fun getPrefsInt(key: String, default: Int = 0): Int {
        return sharedPreferences.getInt(key, default)
    }
    fun getPrefsBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun setPrefsBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)?.apply()
    }

    fun remove(key: String) {
        editor.remove(key).apply()
    }
    fun clearAll() {
        editor.clear().apply()
    }
}