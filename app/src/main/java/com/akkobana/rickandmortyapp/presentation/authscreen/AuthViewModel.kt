package com.akkobana.rickandmortyapp.presentation.authscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    val navigateToSignUpLive = MutableLiveData<Boolean>()
    val navigateToSignInLive = MutableLiveData<Boolean>()

    fun navigateToSignUpFragment() {
        navigateToSignUpLive.value = true
    }

    fun navigateToSignInFragment() {
        navigateToSignInLive.value = true
    }
}