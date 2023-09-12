package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import io.reactivex.Single

interface GetDislikedCharacterUseCase {
    fun getDislikedCharacterById(likedId: Int): Single<DislikedCharacterInfoTuple>
}