package com.akkobana.rickandmortyapp.data.api

import com.akkobana.rickandmortyapp.data.model.CharacterAllResults
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Query

interface ApiRepository {
    fun getCharacterInfo(id: String): Single<CharacterResults>
    fun getCharacterNameAndImage(): Single<CharacterNameImage>

    fun getFilteretCharacterList(name: String): Single<CharacterNameImage>
}