package com.akkobana.rickandmortyapp.presentation.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.domain.dbusecases.deleteall.DeleteAllLikedDislikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
        deleteALlLikedDislikedCharactersUseCase.deleteAllLikedDislikedCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
            }).isDisposed
    }
}