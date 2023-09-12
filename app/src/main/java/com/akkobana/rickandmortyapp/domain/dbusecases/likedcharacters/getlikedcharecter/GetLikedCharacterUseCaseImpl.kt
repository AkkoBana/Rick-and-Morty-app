package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getlikedcharecter

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import io.reactivex.Single
import javax.inject.Inject

class GetLikedCharacterUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : GetLikedCharacterUseCase {
    override fun getLikedById(likedId: Int): Single<LikedCharacterInfoTuple> =
        dataBaseRepository.getLikedCharacterById(likedId)
}