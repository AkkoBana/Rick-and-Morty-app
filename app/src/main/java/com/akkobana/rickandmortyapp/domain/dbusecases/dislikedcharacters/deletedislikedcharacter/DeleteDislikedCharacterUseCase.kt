package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter

import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity

interface DeleteDislikedCharacterUseCase {
    suspend fun deleteDislikedById(dislikedCharacterDbEntity: DislikedCharacterDbEntity)
}