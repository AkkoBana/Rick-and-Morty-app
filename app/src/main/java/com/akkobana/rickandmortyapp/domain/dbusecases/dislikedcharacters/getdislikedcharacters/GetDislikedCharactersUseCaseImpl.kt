package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharacters

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import io.reactivex.Single
import javax.inject.Inject

class GetDislikedCharactersUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): GetDislikedCharactersUseCase {
    override fun getDislikedCharacters(): Single<List<DislikedCharacterInfoTuple>> =
        dataBaseRepository.getAllDislikedCharacters()
}