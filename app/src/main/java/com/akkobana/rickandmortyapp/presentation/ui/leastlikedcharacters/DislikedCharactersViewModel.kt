package com.akkobana.rickandmortyapp.presentation.ui.leastlikedcharacters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters.GetDislikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DislikedCharactersViewModel  @Inject constructor(
    private val getLeastLikedCharactersUseCase: GetDislikedCharactersUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {
    var dislikedCharactersListLive = MutableLiveData<List<CharacterCard>>()
    var dislikedCharactersId = mutableListOf<String>()

    private fun fetchNameAndImage() {
        viewModelScope.launch {
            getApiResponseUseCase.getCharacterNameAndImageById(
                id = dislikedCharactersId,
                name = "",
                status = "",
                gender = ""
            ).flowOn(Dispatchers.IO)
                .collect { dislikedCharactersListLive.value = it }
        }
    }

    fun fetchLeastLikedCharacters() {
        viewModelScope.launch {
            getLeastLikedCharactersUseCase.getDislikedCharacters()
                .flowOn(Dispatchers.IO)
                .collect {
                    for (i in it) {
                        dislikedCharactersId += i.id.toString()
                    }
                    fetchNameAndImage()
                }
        }
    }
}