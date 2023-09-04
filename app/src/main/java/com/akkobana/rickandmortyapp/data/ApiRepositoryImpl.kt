package com.akkobana.rickandmortyapp.data

import android.util.Log
import com.akkobana.rickandmortyapp.data.api.RickAndMortyApi
import com.akkobana.rickandmortyapp.data.model.CharacterAllResults
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
): ApiRepository {
    override fun getCharacterInfo(id: String): Single<CharacterResults> =
        rickAndMortyApi.getCharacterInfo(id)

    override fun getCharacterNameAndImage(): Single<CharacterNameImage> {
        return rickAndMortyApi.getCharacterNameAndImage()}
}