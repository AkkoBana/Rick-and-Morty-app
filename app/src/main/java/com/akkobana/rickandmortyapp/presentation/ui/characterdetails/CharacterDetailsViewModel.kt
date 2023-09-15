package com.akkobana.rickandmortyapp.presentation.ui.characterdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akkobana.rickandmortyapp.data.model.Character
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter.DeleteDislikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid.GetDislikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter.SaveDislikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter.DeleteFavouriteCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter.GetLikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter.SaveLikedCharacterUseCase
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CharacterDetailsViewModel @Inject constructor(
    private val getApiResponseUseCase: GetApiResponseUseCase,
    private val saveFavouriteCharacterUseCase: SaveLikedCharacterUseCase,
    private val getFavouriteCharacterUseCase: GetLikedCharacterUseCase,
    private val deleteFavouriteCharacterUseCase: DeleteFavouriteCharacterUseCase,
    private val saveDislikedCharacterUseCase: SaveDislikedCharacterUseCase,
    private val getDislikedCharacterUseCase: GetDislikedCharacterUseCase,
    private val deleteLeastLikedCharacterUseCase: DeleteDislikedCharacterUseCase
) : ViewModel() {

    val characterDetailsLive = MutableLiveData<CharacterResults>()
    val navigateBackLive = MutableLiveData<Boolean>()
    val isLoadingLive = MutableLiveData<Boolean>()
    val isLikedLive = MutableLiveData<Boolean>()
    val isDislikedLive = MutableLiveData<Boolean>()

    fun fetchCharacterData(id: Int) {
        isLoadingLive.value = true
        viewModelScope.launch {
            getApiResponseUseCase.getCharacterInfo(id.toString())
                .flowOn(Dispatchers.IO)
                .collect { characterDetailsLive.value = it }
        }
    }

    fun insertLikedCharacterInTable(id: Int) {
        val character = Character(id)
        viewModelScope.launch {
            saveFavouriteCharacterUseCase.insertNewLikedCharacter(character.toFavouriteCharacterEntity())
        }
    }

    fun fetchLikedCharacterFromTable(id: Int) {
        viewModelScope.launch {
            getFavouriteCharacterUseCase.getLikedById(id)
                .flowOn(Dispatchers.IO)
                .catch { isLikedLive.value = false }
                .collect { isLikedLive.value = true }
        }
    }

    fun deleteLikedCharacterFromTable(id: Int) {
        val character = Character(id)
        viewModelScope.launch {
            deleteFavouriteCharacterUseCase.deleteFavouriteById(character.toFavouriteCharacterEntity())
        }
    }

    fun insertDislikedCharacterInTable(id: Int) {
        val character = Character(id)
        viewModelScope.launch {
            saveDislikedCharacterUseCase.insertNewDislikedCharacter(character.toLeastLikedCharacterEntity())

        }
    }

    fun fetchDislikedCharacterFromTable(id: Int) {
        viewModelScope.launch {
            getDislikedCharacterUseCase.getDislikedCharacterById(id)
                .flowOn(Dispatchers.IO)
                .catch { isDislikedLive.value = false }
                .collect { isDislikedLive.value = true }

        }
    }

    fun deleteDislikedCharacterFromTable(id: Int) {
        val character = Character(id)
        viewModelScope.launch {
            deleteLeastLikedCharacterUseCase.deleteDislikedById(character.toLeastLikedCharacterEntity())
        }
    }

    fun changeIsLikedValue() {
        isLikedLive.value = !isLikedLive.value!!
        if(isDislikedLive.value == true) isDislikedLive.value = false
    }

    fun changeIsDislikedValue() {
        isDislikedLive.value = !isDislikedLive.value!!
        if (isLikedLive.value == true) isLikedLive.value = false
    }

    fun setNavigateBackFlag() {
        navigateBackLive.value = true
    }

    fun setIsLoadingFalse() {
        isLoadingLive.value = false
    }
}
