package com.akkobana.rickandmortyapp.presentation.ui.leastlikedcharacters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters.GetDislikedCharactersUseCase
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class DislikedCharactersViewModel  @Inject constructor(
    private val getLeastLikedCharactersUseCase: GetDislikedCharactersUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {
    var dislikedCharactersListLive = MutableLiveData<List<CharacterCard>>()
    var dislikedCharactersId = mutableListOf<String>()

    private fun fetchNameAndImage() {
        getApiResponseUseCase.getCharacterNameAndImageById(
            id = dislikedCharactersId,
            name = "",
            status = "",
            gender = ""
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dislikedCharactersListLive.value = it
            }, {
            }).isDisposed
    }

    fun fetchLeastLikedCharacters() {
        getLeastLikedCharactersUseCase.getDislikedCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {  }
            .subscribe({
                for (i in it) {
                    dislikedCharactersId += i.id.toString()
                }
                fetchNameAndImage()
            }, {
            }).isDisposed
    }
}