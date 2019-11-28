package com.intellidev.usecases

import android.content.Context
import android.content.SharedPreferences
import com.intellidev.entities.*

open class PreferencesHelper() {

    companion object {
        private val PREF_BUFFER_PACKAGE_NAME = "org.buffer.android.boilerplate.preferences"




    }

    private val sharedPreferences: SharedPreferences

    init {

        sharedPreferences = applicationLiveData.getApplication().applicationContext.getSharedPreferences(PREF_BUFFER_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store and retrieve the last time data was cached
     */

    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(PREF_KEY_LOGGEDIN, false)
        set(isLoggedIn) = sharedPreferences.edit().putBoolean(PREF_KEY_LOGGEDIN, isLoggedIn).apply()

    var token: String
        get() = "Bearer ${sharedPreferences.getString(PREF_KEY_TOKEN, "")}"
        set(token) = sharedPreferences.edit().putString(PREF_KEY_TOKEN, token).apply()

    var refreshToken: String
        get() = sharedPreferences.getString(PREF_KEY_REFRESH_TOKEN,"")
        set(refreshToken) = sharedPreferences.edit().putString(PREF_KEY_REFRESH_TOKEN, refreshToken).apply()

    var username: String
        get() = sharedPreferences.getString(PREF_KEY_USERNAME,"")
        set(username) = sharedPreferences.edit().putString(PREF_KEY_USERNAME, username).apply()

    var password: String
        get() = sharedPreferences.getString(PREF_KEY_PASSWORD,"")
        set(password) = sharedPreferences.edit().putString(PREF_KEY_PASSWORD, password).apply()

}
