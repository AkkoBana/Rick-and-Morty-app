package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import io.reactivex.Single
import javax.inject.Inject

class GetAllLikedCharactersUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : GetAllLikedCharactersUseCase {
    override fun getAllLikedCharacters(): Single<List<LikedCharacterInfoTuple>> =
        dataBaseRepository.getAllLikedCharacters()
}