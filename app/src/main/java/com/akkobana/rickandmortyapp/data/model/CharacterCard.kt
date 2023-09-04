package com.akkobana.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterCard(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val avatar: String
)