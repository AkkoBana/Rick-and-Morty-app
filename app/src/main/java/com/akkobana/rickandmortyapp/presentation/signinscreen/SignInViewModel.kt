package com.akkobana.rickandmortyapp.presentation.signinscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.domain.getauthdata.GetLoginUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetPasswordUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase,
    private val getPasswordUseCase: GetPasswordUseCase,
    private val saveAuthStateUseCase: SaveAuthStateUseCase
): ViewModel() {

    val checkCredentialLive = MutableLiveData<Boolean>()
    val showErrorToastLive = MutableLiveData<Boolean>()

    fun checkUserEntry(login: String, password: String) {
        val savedLogin = getLoginUseCase.getLogin()
        val savedPassword = getPasswordUseCase.getPassword()
        if (savedLogin == login && savedPassword == password) {
            saveAuthStateUseCase.saveAuthState(true)
            checkCredentialLive.value = true
        } else {
            showErrorToastLive.value = true
        }
    }


}