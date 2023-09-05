package com.akkobana.rickandmortyapp.presentation.charactersscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetAuthStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {

    val authStateLive = MutableLiveData<Boolean>()
    val characterListLive = MutableLiveData<MutableList<CharacterCard>>()

    fun fetchNameAndImage() {
        getApiResponseUseCase.getCharacterNameAndImage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                characterListLive.value = it.results
            }, {

            }).isDisposed
    }

    fun checkAuthState() {
        authStateLive.value = getAuthStateUseCase.getAuthState()
    }

    fun fetchFilteredNameAndImage(charName: String) {
        getApiResponseUseCase.getFilteretCharacterList(charName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                characterListLive.value = it.results
            }, {

            }).isDisposed
    }
}