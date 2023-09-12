package com.akkobana.rickandmortyapp.data.db

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataBaseRepository {
    // Liked
    fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity): Completable
    fun getAllLikedCharacters(): Single<List<LikedCharacterInfoTuple>>
    fun deleteLikedCharacterById(likedCharacter: LikedCharacterDbEntity): Completable
    fun getLikedCharacterById(likedCharacterId: Int): Single<LikedCharacterInfoTuple>

    // Disliked
    fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable
    fun getAllDislikedCharacters(): Single<List<DislikedCharacterInfoTuple>>
    fun deleteDislikedCharacterById(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable
    fun getDislikedCharacterById(dislikedCharacterId: Int): Single<DislikedCharacterInfoTuple>
    fun deleteAllLikedDislikedCharacters(): Completable
}