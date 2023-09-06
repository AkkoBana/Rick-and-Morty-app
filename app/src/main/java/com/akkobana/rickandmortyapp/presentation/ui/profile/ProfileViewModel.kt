package com.akkobana.rickandmortyapp.presentation.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val saveAuthStateUseCase: SaveAuthStateUseCase
): ViewModel() {

    val authStateLive = MutableLiveData<Boolean>()

    fun setAuthStateFalse() {
        saveAuthStateUseCase.saveAuthState(false)
        authStateLive.value = false
    }

}