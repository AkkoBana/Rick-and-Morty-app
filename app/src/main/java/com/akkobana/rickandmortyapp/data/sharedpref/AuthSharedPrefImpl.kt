package com.akkobana.rickandmortyapp.data.sharedpref

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.akkobana.rickandmortyapp.utils.Utils
import javax.inject.Inject

class AuthSharedPrefImpl @Inject constructor(
    private val context: Context
) : AuthSharedPref {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(Utils.SHARED_PREF, Context.MODE_PRIVATE)
    val editor: Editor = sharedPreferences.edit()

    override fun savePassword(password: String) {
        editor.putString(Utils.SHARED_PREF_PASSWORD, password).apply()
    }

    override fun saveLogin(login: String) {
        editor.putString(Utils.SHARED_PREF_LOGIN, login).apply()
    }

    override fun getPassword(): String =
        sharedPreferences.getString(Utils.SHARED_PREF_PASSWORD, "").toString()


    override fun getLogin(): String =
        sharedPreferences.getString(Utils.SHARED_PREF_LOGIN, "").toString()

    override fun saveAuthState(state: Boolean) {
        editor.putBoolean(Utils.SHARED_PREF_STATE, state).apply()
    }

    override fun getAuthState(): Boolean =
        sharedPreferences.getBoolean(Utils.SHARED_PREF_STATE, false)

}