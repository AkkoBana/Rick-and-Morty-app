package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.deletelikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import io.reactivex.Completable
import javax.inject.Inject

class DeleteFavouriteCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): DeleteFavouriteCharacterUseCase {

    override fun deleteFavouriteById(favourite: LikedCharacterDbEntity): Completable {
        return dataBaseRepository.deleteLikedCharacterById(favourite)
    }
}