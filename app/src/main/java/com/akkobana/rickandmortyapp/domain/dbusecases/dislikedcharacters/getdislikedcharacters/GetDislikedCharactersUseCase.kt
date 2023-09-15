package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow

interface GetDislikedCharactersUseCase {
    fun getDislikedCharacters(): Flow<List<DislikedCharacterInfoTuple>>
}