package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter

import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow

interface GetLikedCharacterUseCase {
    fun getLikedById(likedId: Int): Flow<LikedCharacterInfoTuple>
}