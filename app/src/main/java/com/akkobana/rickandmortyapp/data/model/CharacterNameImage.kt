package com.akkobana.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterNameImage(
    @SerializedName("results")
    val results: MutableList<CharacterCard>
)

