package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import io.reactivex.Completable
import javax.inject.Inject

class SaveLikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : SaveLikedCharacterUseCase {
    override fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity): Completable =
            dataBaseRepository.insertNewLikedCharacter(likedCharacter)
}