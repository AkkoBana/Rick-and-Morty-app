package com.akkobana.rickandmortyapp.presentation.charactersscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.domain.getauthdata.GetAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase
) : ViewModel() {

    val authState = MutableLiveData<Boolean>()
    val navigateToProfileFragmentFlag = MutableLiveData<Boolean>()

    fun checkAuthState() {
        authState.value = getAuthStateUseCase.getAuthState()
    }

    fun navigateToProfileFragment() {
        navigateToProfileFragmentFlag.value = true
    }

}