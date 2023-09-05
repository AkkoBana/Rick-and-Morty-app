package com.akkobana.rickandmortyapp.domain.getapidata

import com.akkobana.rickandmortyapp.data.api.ApiRepository
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Single
import javax.inject.Inject

class GetApiResponseUseCaseImpl @Inject constructor(
    private val apiRepository: ApiRepository
): GetApiResponseUseCase   {
    override fun getCharacterInfo(id: String): Single<CharacterResults> =
        apiRepository.getCharacterInfo(id)


    override fun getCharacterNameAndImage(name: String): Single<CharacterNameImage> =
        apiRepository.getCharacterNameAndImage(name)

}