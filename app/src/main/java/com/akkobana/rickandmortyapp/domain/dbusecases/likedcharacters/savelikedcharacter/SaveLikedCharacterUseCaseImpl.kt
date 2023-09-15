package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.savelikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import javax.inject.Inject

class SaveLikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : SaveLikedCharacterUseCase {
    override suspend fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity) {
        dataBaseRepository.insertNewLikedCharacter(likedCharacter)
    }
}