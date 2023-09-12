package com.akkobana.rickandmortyapp.presentation.ui.characterdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
        getApiResponseUseCase.getCharacterInfo(id.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                characterDetailsLive.value = it
            }, {

            }).isDisposed
    }

    fun insertLikedCharacterInTable(id: Int) {
        val character = Character(id)
        saveFavouriteCharacterUseCase.insertNewLikedCharacter(character.toFavouriteCharacterEntity())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {}, {}
            ).isDisposed
    }

    fun fetchLikedCharacterFromTable(id: Int) {
        getFavouriteCharacterUseCase.getLikedById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                isLikedLive.value = true
            }, {
                isLikedLive.value = false
            }).isDisposed
    }

    fun deleteLikedCharacterFromTable(id: Int) {
        val character = Character(id)
        deleteFavouriteCharacterUseCase.deleteFavouriteById(character.toFavouriteCharacterEntity())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { },
                { }
            ).isDisposed
    }

    fun insertDislikedCharacterInTable(id: Int) {
        val character = Character(id)
        saveDislikedCharacterUseCase.insertNewDislikedCharacter(character.toLeastLikedCharacterEntity())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { },
                { }
            ).isDisposed
    }

    fun fetchDislikedCharacterFromTable(id: Int) {
        getDislikedCharacterUseCase.getDislikedCharacterById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                isDislikedLive.value = true
            }, {
                isDislikedLive.value = false
            }).isDisposed
    }

    fun deleteDislikedCharacterFromTable(id: Int) {
        val character = Character(id)
        deleteLeastLikedCharacterUseCase.deleteDislikedById(character.toLeastLikedCharacterEntity())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, {}
            ).isDisposed
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
