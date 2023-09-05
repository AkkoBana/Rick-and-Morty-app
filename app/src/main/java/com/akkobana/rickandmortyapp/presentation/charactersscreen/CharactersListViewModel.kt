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
    val isLoading = MutableLiveData<Boolean>()
    private var nameCharacter: String = ""

    fun fetchNameAndImage(name: String = nameCharacter) {
        nameCharacter = name
        isLoading.value = true
        getApiResponseUseCase.getCharacterNameAndImage(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {isLoading.value = false  }
            .subscribe({
                characterListLive.value = it.results
            }, {

            }).isDisposed

    }


    fun checkAuthState() {
        authStateLive.value = getAuthStateUseCase.getAuthState()
    }
}