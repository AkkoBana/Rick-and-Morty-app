package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter

import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity

interface SaveLikedCharacterUseCase {
    suspend fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity)
}