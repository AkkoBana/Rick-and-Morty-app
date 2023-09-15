package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import javax.inject.Inject

class DeleteDislikedCharacterUseCaseImpl@Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): DeleteDislikedCharacterUseCase {
    override suspend fun deleteDislikedById(dislikedCharacterDbEntity: DislikedCharacterDbEntity) {
        dataBaseRepository.deleteDislikedCharacterById(dislikedCharacterDbEntity)
    }

}