package com.akkobana.rickandmortyapp.data.db

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharactersDao
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharactersDao
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(
    private val likedCharactersDao: LikedCharactersDao,
    private val dislikedCharactersDao: DislikedCharactersDao
) : DataBaseRepository {
    override suspend fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity) {
        //likedCharactersDao.insertNewLikedCharacter(likedCharacter)
    }

    override fun getAllLikedCharacters(): Flow<List<LikedCharacterInfoTuple>> =
        likedCharactersDao.getAllLikedCharacters()

    override suspend fun deleteLikedCharacterById(likedCharacter: LikedCharacterDbEntity) {
       // likedCharactersDao.deleteLikedCharacterById(likedCharacter)
    }

    override fun getLikedCharacterById(likedCharacterId: Int): Flow<LikedCharacterInfoTuple> =
        likedCharactersDao.getLikedCharacterById(likedCharacterId)

    override suspend fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity) {
       // dislikedCharactersDao.insertNewDislikedCharacter(dislikedCharacterDbEntity)
    }

    override fun getAllDislikedCharacters(): Flow<List<DislikedCharacterInfoTuple>> =
        dislikedCharactersDao.getDislikedCharacters()

    override suspend fun deleteDislikedCharacterById(dislikedCharacterDbEntity: DislikedCharacterDbEntity) {
       // dislikedCharactersDao.deleteDislikedCharacterById(dislikedCharacterDbEntity)
    }

    override fun getDislikedCharacterById(dislikedCharacterId: Int): Flow<DislikedCharacterInfoTuple> =
        dislikedCharactersDao.getDislikedCharacterById(dislikedCharacterId)

    override fun deleteAllLikedDislikedCharacters() {
        likedCharactersDao.deleteAllLikedCharactersFromTable()
        dislikedCharactersDao.deleteAllDislikedCharactersFromTable()
    }

}