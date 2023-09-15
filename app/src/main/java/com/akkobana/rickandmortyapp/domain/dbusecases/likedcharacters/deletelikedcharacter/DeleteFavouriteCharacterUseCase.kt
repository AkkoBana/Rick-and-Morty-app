package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter

import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity

interface DeleteFavouriteCharacterUseCase {
    suspend fun deleteFavouriteById(favourite: LikedCharacterDbEntity)
}