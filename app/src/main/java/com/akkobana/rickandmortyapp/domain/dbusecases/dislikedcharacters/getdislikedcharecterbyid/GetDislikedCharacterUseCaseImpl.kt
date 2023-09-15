package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDislikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): GetDislikedCharacterUseCase {
    override fun getDislikedCharacterById(likedId: Int): Flow<DislikedCharacterInfoTuple> =
        dataBaseRepository.getDislikedCharacterById(likedId)
}