package com.akkobana.rickandmortyapp.presentation.characterinfoscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
internal class CharacterDetailsViewModel @Inject constructor(
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {

    val characterDetailsLive = MutableLiveData<CharacterResults>()
    val navigateBackLive = MutableLiveData<Boolean>()

    fun fetchCharacterData(id: Int) {
        getApiResponseUseCase.getCharacterInfo(id.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                characterDetailsLive.value = it
            }, {

            }).isDisposed
    }

    fun setNavigateBackFlag() {
        navigateBackLive.value = true
    }


}
