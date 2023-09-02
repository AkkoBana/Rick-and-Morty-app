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

    val validationFlag = MutableLiveData<Boolean>()
    val showErrorToastFlag = MutableLiveData<Boolean>()

    fun checkUserEntry(login: String, password: String) {
        val aboba = getLoginUseCase.getLogin()
        val aboab = getPasswordUseCase.getPassword()
        if (aboba == login && aboab == password) {
            saveAuthStateUseCase.saveAuthState(true)
            validationFlag.value = true
        } else {
            showErrorToastFlag.value = true
        }
    }


}