package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Single
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
) : ApiRepository {
    override fun getCharacterInfo(id: String): Single<CharacterResults> =
        rickAndMortyApi.getCharacterInfo(id)

    override fun getCharacterNameAndImage(name: String): Single<CharacterNameImage> {
        return rickAndMortyApi.getCharacterNameAndImage(name)
    }

}