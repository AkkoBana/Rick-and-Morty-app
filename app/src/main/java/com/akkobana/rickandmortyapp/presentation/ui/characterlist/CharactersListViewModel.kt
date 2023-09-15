package com.akkobana.rickandmortyapp.presentation.ui.characterlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetAuthStateUseCase
import com.akkobana.rickandmortyapp.utils.FilterListEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getAuthStateUseCase: GetAuthStateUseCase,
    private val getApiResponseUseCase: GetApiResponseUseCase
) : ViewModel() {
    val filterEntity = FilterListEntity.filterEntity
    val authStateState = MutableStateFlow(false)
    val characterListState = MutableLiveData<MutableList<CharacterCard>>()
    val isLoadingState = MutableStateFlow(true)
    private var nameCharacter: String = ""

    fun fetchNameAndImage(
        name: String = nameCharacter,
        status: String? = "",
        gender: String? = ""
    ) {
        nameCharacter = name

        viewModelScope.launch {
            getApiResponseUseCase.getAllCharactersNameAndImage(
                name = name,
                status = status ?: "",
                gender = gender ?: ""
            )
                .flowOn(Dispatchers.IO)
                .catch {
                    isLoadingState.emit(false)
                    Log.e("Error", "API Error", it)
                }
                .collect {
                    characterListState.value = it.results!!
                }
        }

    }

    fun checkAuthState() {
        viewModelScope.launch {
            authStateState.emit(getAuthStateUseCase.getAuthState())
        }

    }

    fun characterAdapterCallBack(id: Int, callBack: (Int) -> Unit) {
        try {
            callBack.invoke(id)
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.d("MyLog", it) }
        }
    }

}