package com.akkobana.rickandmortyapp.presentation.ui.characterlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetAuthStateUseCase
import com.akkobana.rickandmortyapp.utils.FilterListEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {
    val filterEntity = FilterListEntity.filterEntity
    val authStateLive = MutableLiveData<Boolean>()
    val characterListLive = MutableLiveData<MutableList<CharacterCard>>()
    val isLoadingLive = MutableLiveData<Boolean>()
    private var nameCharacter: String = ""

    fun fetchNameAndImage(
        name: String = nameCharacter,
        status: String? = "",
        gender: String? = ""
    ) {
        nameCharacter = name
        isLoadingLive.value = true

        getApiResponseUseCase.getAllCharactersNameAndImage(
            name = name,
            status = status ?: "",
            gender = gender ?: ""
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { isLoadingLive.value = false }
            .subscribe({
                characterListLive.value = it.results!!
            }, {
                isLoadingLive.value = false
            }).isDisposed
    }

    fun checkAuthState() {
        authStateLive.value = getAuthStateUseCase.getAuthState()
    }

    fun characterAdapterCallBack(id: Int, callBack: (Int) -> Unit) {
        try {
            callBack.invoke(id)
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.d("MyLog", it) }
        }
    }

}