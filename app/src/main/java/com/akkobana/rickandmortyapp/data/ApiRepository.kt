package com.akkobana.rickandmortyapp.data

import com.akkobana.rickandmortyapp.data.model.CharacterAllResults
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Observable
import io.reactivex.Single

interface ApiRepository {
    fun getCharacterInfo(id: String): Single<CharacterResults>
    fun getCharacterNameAndImage(): Single<CharacterNameImage>
}