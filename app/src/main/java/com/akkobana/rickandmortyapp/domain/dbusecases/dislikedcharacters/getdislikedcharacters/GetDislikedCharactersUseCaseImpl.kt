package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDislikedCharactersUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): GetDislikedCharactersUseCase {
    override fun getDislikedCharacters(): Flow<List<DislikedCharacterInfoTuple>> =
        dataBaseRepository.getAllDislikedCharacters()
}