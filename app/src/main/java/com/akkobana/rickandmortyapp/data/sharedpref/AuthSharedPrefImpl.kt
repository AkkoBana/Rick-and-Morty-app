package com.akkobana.rickandmortyapp.data.sharedpref

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import javax.inject.Inject

class AuthSharedPrefImpl @Inject constructor(
    context: Context
) : AuthSharedPref {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
    private val editor: Editor = sharedPreferences.edit()

    override fun savePassword(password: String) {
        editor.putString(SHARED_PREF_PASSWORD, password).apply()
    }

    override fun saveLogin(login: String) {
        editor.putString(SHARED_PREF_LOGIN, login).apply()
    }

    override fun getPassword(): String =
        sharedPreferences.getString(SHARED_PREF_PASSWORD, "").toString()


    override fun getLogin(): String =
        sharedPreferences.getString(SHARED_PREF_LOGIN, "").toString()

    override fun saveAuthState(state: Boolean) {
        editor.putBoolean(SHARED_PREF_STATE, state).apply()
    }

    override fun getAuthState(): Boolean =
        sharedPreferences.getBoolean(SHARED_PREF_STATE, false)

    companion object {
        const val SHARED_PREF = "auth-data"
        const val SHARED_PREF_LOGIN = "login"
        const val SHARED_PREF_PASSWORD = "password"
        const val SHARED_PREF_STATE = "state"
    }
}