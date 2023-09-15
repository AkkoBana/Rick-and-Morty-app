package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow

interface GetDislikedCharacterUseCase {
    fun getDislikedCharacterById(likedId: Int): Flow<DislikedCharacterInfoTuple>
}