package com.akkobana.rickandmortyapp.presentation.ui.favourites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters.GetAllLikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LikedCharactersViewModel @Inject constructor(
    private val getFavouriteCharactersUseCase: GetAllLikedCharactersUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {

    var likedCharactersListLive = MutableLiveData<List<CharacterCard>>()
    private val likedCharactersCharactersId = mutableListOf<String>()

    fun fetchNameAndImage() {
        getApiResponseUseCase.getCharacterNameAndImageById(
            id = likedCharactersCharactersId,
            name = "",
            status = "",
            gender = ""
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                likedCharactersListLive.value = it
            }, {
            }).isDisposed
    }

    fun fetchLikedCharactersFromTable() {
        getFavouriteCharactersUseCase.getAllLikedCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                for (i in it) {
                    likedCharactersCharactersId += i.id.toString()
                }
                fetchNameAndImage()
            }, {
            }).isDisposed
    }
}