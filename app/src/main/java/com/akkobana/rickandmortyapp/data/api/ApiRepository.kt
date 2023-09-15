package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    fun getCharacterInfo(id: String): Flow<CharacterResults>
    fun getAllCharactersNameAndImage(
        name: String,
        status: String,
        gender: String
    ): Flow<CharacterNameImage>

    fun getCharacterNameAndImageById(
        id: List<String>,
        name: String,
        status: String,
        gender: String
    ): Flow<List<CharacterCard>>

}