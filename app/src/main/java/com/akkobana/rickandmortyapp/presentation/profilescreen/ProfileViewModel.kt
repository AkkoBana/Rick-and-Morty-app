package com.akkobana.rickandmortyapp.presentation.profilescreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val saveAuthStateUseCase: SaveAuthStateUseCase
): ViewModel() {

    val authStateFlag = MutableLiveData<Boolean>()

    fun setAuthStateFalse() {
        saveAuthStateUseCase.saveAuthState(false)
        authStateFlag.value = false
    }

}