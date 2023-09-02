package com.akkobana.rickandmortyapp.data.sharedpref

interface AuthSharedPref {
    fun savePassword(password: String)
    fun saveLogin(login: String)
    fun getPassword(): String
    fun getLogin(): String
    fun saveAuthState(state: Boolean)
    fun getAuthState(): Boolean
}