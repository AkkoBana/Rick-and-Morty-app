package com.akkobana.rickandmortyapp.domain.getapidata

import com.akkobana.rickandmortyapp.data.model.CharacterAllResults
import com.akkobana.rickandmortyapp.data.model.CharacterNameImage
import com.akkobana.rickandmortyapp.data.model.CharacterResults
import io.reactivex.Observable
import io.reactivex.Single

interface GetApiResponseUseCase {
    fun getCharacterInfo(id: String): Single<CharacterResults>
    fun getCharacterNameAndImage(name: String): Single<CharacterNameImage>
}