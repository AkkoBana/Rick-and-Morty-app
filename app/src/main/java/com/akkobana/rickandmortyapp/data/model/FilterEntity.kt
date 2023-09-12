package com.akkobana.rickandmortyapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterEntity (
    val main : List<String>,
    val status : List<String>,
    val gender : List<String>,
    ) : Parcelable