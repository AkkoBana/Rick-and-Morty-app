package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
) : ApiRepository {
    override fun getCharacterInfo(id: String): Flow<CharacterResults> =
        rickAndMortyApi.getCharacterInfo(id)

    override fun getAllCharactersNameAndImage(
        name: String,
        status: String,
        gender: String
    ): Flow<CharacterNameImage> =
        rickAndMortyApi.getAllCharactersNameAndImage(name, status, gender)

    override fun getCharacterNameAndImageById(
        id: List<String>,
        name: String,
        status: String,
        gender: String
    ): Flow<List<CharacterCard>> =
        rickAndMortyApi.getCharacterNameAndImageById(id,name,status,gender)
}