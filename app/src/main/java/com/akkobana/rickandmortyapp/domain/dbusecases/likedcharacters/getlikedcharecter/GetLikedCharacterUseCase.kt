package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter

import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import io.reactivex.Single

interface GetLikedCharacterUseCase {
    fun getLikedById(likedId: Int): Single<LikedCharacterInfoTuple>
}