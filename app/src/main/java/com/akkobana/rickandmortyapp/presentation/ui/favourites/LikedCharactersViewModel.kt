package com.akkobana.rickandmortyapp.presentation.ui.favourites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters.GetAllLikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikedCharactersViewModel @Inject constructor(
    private val getFavouriteCharactersUseCase: GetAllLikedCharactersUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {

    var likedCharactersListLive = MutableLiveData<List<CharacterCard>>()
    private val likedCharactersCharactersId = mutableListOf<String>()

    fun fetchNameAndImage() {
        viewModelScope.launch {
            getApiResponseUseCase.getCharacterNameAndImageById(
                id = likedCharactersCharactersId,
                name = "",
                status = "",
                gender = ""
            )
                .flowOn(Dispatchers.IO)
                .collect {
                    likedCharactersListLive.value = it
                }
        }
    }

    fun fetchLikedCharactersFromTable() {
        viewModelScope.launch {
            getFavouriteCharactersUseCase.getAllLikedCharacters()
                .flowOn(Dispatchers.IO)
                .collect {
                    for (i in it) {
                        likedCharactersCharactersId += i.id.toString()
                    }
                    fetchNameAndImage()
                }
        }
    }
}