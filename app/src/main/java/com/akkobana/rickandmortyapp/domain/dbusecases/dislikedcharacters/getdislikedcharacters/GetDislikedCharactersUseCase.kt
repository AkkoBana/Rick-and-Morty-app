package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import io.reactivex.Single

interface GetDislikedCharactersUseCase {
    fun getDislikedCharacters(): Single<List<DislikedCharacterInfoTuple>>
}