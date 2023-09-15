package com.akkobana.rickandmortyapp.presentation.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akkobana.rickandmortyapp.domain.dbusecases.deleteall.DeleteAllLikedDislikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val saveAuthStateUseCase: SaveAuthStateUseCase,
    private val deleteALlLikedDislikedCharactersUseCase: DeleteAllLikedDislikedCharactersUseCase
): ViewModel() {

    val authStateLive = MutableLiveData<Boolean>()

    fun setAuthStateFalse() {
        saveAuthStateUseCase.saveAuthState(false)
        authStateLive.value = false
    }

    fun clearTables() {
        /*viewModelScope.launch {
            deleteALlLikedDislikedCharactersUseCase.deleteAllLikedDislikedCharacters()
        }*/
    }
}