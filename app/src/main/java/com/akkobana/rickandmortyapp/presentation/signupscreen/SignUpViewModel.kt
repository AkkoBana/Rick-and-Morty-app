package com.akkobana.rickandmortyapp.presentation.signupscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.domain.getauthdata.GetLoginUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetPasswordUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveLoginUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SavePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveLoginUseCase: SaveLoginUseCase,
    private val savePasswordUseCase: SavePasswordUseCase,
    private val saveAuthStateUseCase: SaveAuthStateUseCase
): ViewModel() {
    val validationFlag = MutableLiveData<Boolean>()

    fun saveUserData(login: String, password: String) {
        saveLoginUseCase.saveLogin(login)
        savePasswordUseCase.savePassword(password)
        saveAuthStateUseCase.saveAuthState(true)
        validationFlag.value = true
    }

}