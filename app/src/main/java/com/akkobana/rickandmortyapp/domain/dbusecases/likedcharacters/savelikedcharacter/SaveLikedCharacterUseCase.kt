package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter

import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import io.reactivex.Completable

interface SaveLikedCharacterUseCase {
    fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity): Completable
}