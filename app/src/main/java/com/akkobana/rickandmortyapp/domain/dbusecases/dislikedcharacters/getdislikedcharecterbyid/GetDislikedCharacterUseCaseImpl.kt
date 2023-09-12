package com.akkobana.rickandmortyapp.domain.dbusecases.dislikedcharacters.getdislikedcharecterbyid

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import io.reactivex.Single
import javax.inject.Inject

class GetDislikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): GetDislikedCharacterUseCase {
    override fun getDislikedCharacterById(likedId: Int): Single<DislikedCharacterInfoTuple> =
        dataBaseRepository.getDislikedCharacterById(likedId)
}