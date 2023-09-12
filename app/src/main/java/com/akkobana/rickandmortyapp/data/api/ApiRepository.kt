package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Single

interface ApiRepository {
    fun getCharacterInfo(id: String): Single<CharacterResults>
    fun getAllCharactersNameAndImage(
        name: String,
        status: String,
        gender: String
    ): Single<CharacterNameImage>

    fun getCharacterNameAndImageById(
        id: List<String>,
        name: String,
        status: String,
        gender: String
    ): Single<List<CharacterCard>>

}