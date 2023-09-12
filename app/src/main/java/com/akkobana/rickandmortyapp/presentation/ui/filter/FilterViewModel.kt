package com.akkobana.rickandmortyapp.presentation.ui.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akkobana.rickandmortyapp.presentation.adapters.filter.FilterAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val STATUS_KEY = "status"
const val GENDER_KEY = "gender"

@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {
    val filterEntityLive = MutableLiveData<MutableMap<String, String>>()
    val filterEntity = mutableMapOf<String, String>()
    val dismissDialogFlagLive = MutableLiveData<Boolean>()

    fun checkCallBack(filterCallBack: FilterAdapter.CallBack) {

        when (filterCallBack) {
            is FilterAdapter.CallBack.StatusValue -> {
                saveStatusFilterValue(filterCallBack.statusFilterValue)
            }

            is FilterAdapter.CallBack.GenderValue -> {
                saveGenderFilterValue(filterCallBack.genderFilterValue)
            }

            is FilterAdapter.CallBack.ButtonListener -> {
                if (filterCallBack.isSaveOrCancel) {
                    saveFilterEntity()
                    dismissDialogFlagLive.value = true
                } else {
                    dismissDialogFlagLive.value = true
                }
            }
        }
    }

    private fun saveStatusFilterValue(filterValue: String) {
        filterEntity[STATUS_KEY] = filterValue
    }

    private fun saveGenderFilterValue(filterValue: String) {
        filterEntity[GENDER_KEY] = filterValue
    }


    private fun saveFilterEntity() {
        filterEntityLive.value = filterEntity
    }


}