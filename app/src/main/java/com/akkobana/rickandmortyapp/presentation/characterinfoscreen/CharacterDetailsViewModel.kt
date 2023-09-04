package com.akkobana.rickandmortyapp.presentation.characterinfoscreen

import android.util.Log
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

    val characterInfo = MutableLiveData<CharacterResults>()
    val navigateToBackFlag = MutableLiveData<Boolean>()

    fun fetchCharacterData(id: Int) {
        Log.d("MyLog", id.toString())
        getApiResponseUseCase.getCharacterInfo(id.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                characterInfo.value = it
            }, {

            }).isDisposed
    }

    fun setNavigateToBackFlag() {
        navigateToBackFlag.value = true
    }


}
