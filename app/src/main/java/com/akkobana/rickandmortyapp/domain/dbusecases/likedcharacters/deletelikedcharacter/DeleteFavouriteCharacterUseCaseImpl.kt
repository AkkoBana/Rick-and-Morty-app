package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import javax.inject.Inject

class DeleteFavouriteCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): DeleteFavouriteCharacterUseCase {

    override suspend fun deleteFavouriteById(favourite: LikedCharacterDbEntity) {
        dataBaseRepository.deleteLikedCharacterById(favourite)
    }
}