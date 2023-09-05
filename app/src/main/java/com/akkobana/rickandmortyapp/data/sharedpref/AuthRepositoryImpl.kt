package com.akkobana.rickandmortyapp.data.sharedpref

import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authSharedPref: AuthSharedPref
) : AuthRepository {
    override fun savePassword(password: String) {
        authSharedPref.savePassword(password)
    }

    override fun saveLogin(login: String) {
        authSharedPref.saveLogin(login)
    }

    override fun getPassword(): String =
        authSharedPref.getPassword()


    override fun getLogin(): String =
        authSharedPref.getLogin()

    override fun saveAuthState(state: Boolean) {
        authSharedPref.saveAuthState(state)
    }

    override fun getAuthState(): Boolean =
        authSharedPref.getAuthState()

}