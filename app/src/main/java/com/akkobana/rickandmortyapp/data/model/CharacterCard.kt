package com.akkobana.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterCard(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("image")
    val avatar: String? = null
)