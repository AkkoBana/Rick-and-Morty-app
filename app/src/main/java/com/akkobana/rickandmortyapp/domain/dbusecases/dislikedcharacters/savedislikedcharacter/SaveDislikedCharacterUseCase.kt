package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter

import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity

interface SaveDislikedCharacterUseCase {
    suspend fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity)
}