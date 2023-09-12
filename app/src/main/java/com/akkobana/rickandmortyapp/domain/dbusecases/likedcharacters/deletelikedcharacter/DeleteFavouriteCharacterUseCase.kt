package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter

import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import io.reactivex.Completable

interface DeleteFavouriteCharacterUseCase {
    fun deleteFavouriteById(favourite: LikedCharacterDbEntity): Completable
}