package com.akkobana.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName


data class CharacterResults(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("species")
    val species: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("created")
    val created: String? = null
)