package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters

import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow

interface GetAllLikedCharactersUseCase {
    fun getAllLikedCharacters(): Flow<List<LikedCharacterInfoTuple>>
}