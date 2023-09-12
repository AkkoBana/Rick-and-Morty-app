package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.deletedislikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import io.reactivex.Completable
import javax.inject.Inject

class DeleteDislikedCharacterUseCaseImpl@Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): DeleteDislikedCharacterUseCase {
    override fun deleteDislikedById(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable
     = dataBaseRepository.deleteDislikedCharacterById(dislikedCharacterDbEntity)

}