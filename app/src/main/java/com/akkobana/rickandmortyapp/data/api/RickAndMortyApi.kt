package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterAllResults
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RickAndMortyApi {
    @GET("character/{id}")
    fun getCharacterInfo(
        @Path("id")
        id: String
    ): Single<CharacterResults>

    @GET("character")
    fun getCharacterNameAndImage(): Single<CharacterNameImage>

}