package com.akkobana.rickandmortyapp.data.db

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import kotlinx.coroutines.flow.Flow

interface DataBaseRepository {
    // Liked
    suspend fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity)
    fun getAllLikedCharacters(): Flow<List<LikedCharacterInfoTuple>>
    suspend fun deleteLikedCharacterById(likedCharacter: LikedCharacterDbEntity)
    fun getLikedCharacterById(likedCharacterId: Int): Flow<LikedCharacterInfoTuple>

    // Disliked
    suspend fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity)
    fun getAllDislikedCharacters(): Flow<List<DislikedCharacterInfoTuple>>
    suspend fun deleteDislikedCharacterById(dislikedCharacterDbEntity: DislikedCharacterDbEntity)
    fun getDislikedCharacterById(dislikedCharacterId: Int): Flow<DislikedCharacterInfoTuple>
    fun deleteAllLikedDislikedCharacters()
}