package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : GetLikedCharacterUseCase {
    override fun getLikedById(likedId: Int): Flow<LikedCharacterInfoTuple> =
        dataBaseRepository.getLikedCharacterById(likedId)
}