package com.akkobana.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterAllResults(
    @SerializedName("results")
    val results: CharacterResults
)