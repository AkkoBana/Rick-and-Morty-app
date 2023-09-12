package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter

import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import io.reactivex.Completable

interface SaveDislikedCharacterUseCase {
    fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable
}