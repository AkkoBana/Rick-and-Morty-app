package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.savedislikedcharacter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import io.reactivex.Completable
import javax.inject.Inject

class SaveDislikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : SaveDislikedCharacterUseCase {
    override fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable =
        dataBaseRepository.insertNewDislikedCharacter(dislikedCharacterDbEntity)

}