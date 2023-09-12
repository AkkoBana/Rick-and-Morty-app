package com.akkobana.rickandmortyapp.domain.getapidata

import com.akkobana.rickandmortyapp.data.api.ApiRepository
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Single
import javax.inject.Inject

class GetApiResponseUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): GetApiResponseUseCase {
    override fun getCharacterInfo(id: String): Single<CharacterResults> =
        apiRepository.getCharacterInfo(id)


    override fun getAllCharactersNameAndImage(
        name: String,
        status: String,
        gender: String
    ): Single<CharacterNameImage> =
        apiRepository.getAllCharactersNameAndImage(name, status, gender)

    override fun getCharacterNameAndImageById(
        id: List<String>,
        name: String,
        status: String,
        gender: String
    ): Single<List<CharacterCard>> =
        apiRepository.getCharacterNameAndImageById(id,name,status,gender)

}