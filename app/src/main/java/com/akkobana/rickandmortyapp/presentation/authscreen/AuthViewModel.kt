package com.akkobana.rickandmortyapp.presentation.authscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(): ViewModel() {

    val navigateToSignUpFlag = MutableLiveData<Boolean>()
    val navigateToSignInFlag = MutableLiveData<Boolean>()

    fun navigateToSignUpFragment() {
        navigateToSignUpFlag.value = true
    }

    fun navigateToSignInFragment() {
        navigateToSignInFlag.value = true
    }
}