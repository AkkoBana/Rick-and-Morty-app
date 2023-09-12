package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
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

    @GET("character/")
    fun getAllCharactersNameAndImage(
        @Query("name")
        name: String,
        @Query("status")
        status: String,
        @Query("gender")
        gender: String
    ): Single<CharacterNameImage>

    @GET("character/{id}")
    fun getCharacterNameAndImageById(
        @Path("id")
        id: List<String>,
        @Query("name")
        name: String,
        @Query("status")
        status: String,
        @Query("gender")
        gender: String
    ): Single<List<CharacterCard>>

}