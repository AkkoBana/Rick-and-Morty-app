package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import javax.inject.Inject

class SaveDislikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : SaveDislikedCharacterUseCase {
    override suspend fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity) =
        dataBaseRepository.insertNewDislikedCharacter(dislikedCharacterDbEntity)

}