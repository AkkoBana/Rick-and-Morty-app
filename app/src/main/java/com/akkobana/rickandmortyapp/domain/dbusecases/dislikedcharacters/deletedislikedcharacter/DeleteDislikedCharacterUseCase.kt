package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter

import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import io.reactivex.Completable

interface DeleteDislikedCharacterUseCase {
    fun deleteDislikedById(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable
}