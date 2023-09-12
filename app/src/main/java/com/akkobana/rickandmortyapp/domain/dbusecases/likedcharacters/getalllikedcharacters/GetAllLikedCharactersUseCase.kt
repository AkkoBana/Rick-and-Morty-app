package com.akkobana.rickandmortyapp.domain.dbusecases.likedcharacters.getalllikedcharacters

import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import io.reactivex.Single

interface GetAllLikedCharactersUseCase {
    fun getAllLikedCharacters(): Single<List<LikedCharacterInfoTuple>>
}