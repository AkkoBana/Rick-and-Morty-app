package com.akkobana.rickandmortyapp.domain.getapidata

import com.akkobana.rickandmortyapp.data.api.ApiRepository
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetApiResponseUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): GetApiResponseUseCase {
    override fun getCharacterInfo(id: String): Flow<CharacterResults> =
        apiRepository.getCharacterInfo(id)


    override fun getAllCharactersNameAndImage(
        name: String,
        status: String,
        gender: String
    ): Flow<CharacterNameImage> =
        apiRepository.getAllCharactersNameAndImage(name, status, gender)

    override fun getCharacterNameAndImageById(
        id: List<String>,
        name: String,
        status: String,
        gender: String
    ): Flow<List<CharacterCard>> =
        apiRepository.getCharacterNameAndImageById(id,name,status,gender)

}