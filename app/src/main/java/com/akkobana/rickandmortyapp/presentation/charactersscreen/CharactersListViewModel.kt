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

    val authState = MutableLiveData<Boolean>()
    val navigateToProfileFragmentFlag = MutableLiveData<Boolean>()
    val characterList = MutableLiveData<MutableList<CharacterCard>>()
    val searchCharacterList = MutableLiveData<MutableList<CharacterCard>>()

    fun fetchNameAndImage() {
        getApiResponseUseCase.getCharacterNameAndImage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                characterList.value = it.results
            }, {

            }).isDisposed
    }

    fun checkAuthState() {
        authState.value = getAuthStateUseCase.getAuthState()
    }

    fun changeNavigateToProfileFragmentFlag() {
        navigateToProfileFragmentFlag.value = !navigateToProfileFragmentFlag.value!!
    }

    fun filterCharacterList(charName: String) {
        searchCharacterList.value =
            characterList.value?.filter { charName.lowercase() in it.name.lowercase() } as MutableList<CharacterCard>?
    }
}