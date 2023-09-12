package com.akkobana.rickandmortyapp.data.db

import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharactersDao
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharacterInfoTuple
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharactersDao
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(
    private val likedCharactersDao: LikedCharactersDao,
    private val dislikedCharactersDao: DislikedCharactersDao
) : DataBaseRepository {
    override fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity): Completable =
        likedCharactersDao.insertNewLikedCharacter(likedCharacter)

    override fun getAllLikedCharacters(): Single<List<LikedCharacterInfoTuple>> =
        likedCharactersDao.getAllLikedCharacters()

    override fun deleteLikedCharacterById(likedCharacter: LikedCharacterDbEntity): Completable =
        likedCharactersDao.deleteLikedCharacterById(likedCharacter)

    override fun getLikedCharacterById(likedCharacterId: Int): Single<LikedCharacterInfoTuple> =
        likedCharactersDao.getLikedCharacterById(likedCharacterId)

    override fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable =
        dislikedCharactersDao.insertNewDislikedCharacter(dislikedCharacterDbEntity)

    override fun getAllDislikedCharacters(): Single<List<DislikedCharacterInfoTuple>> =
        dislikedCharactersDao.getDislikedCharacters()

    override fun deleteDislikedCharacterById(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable =
        dislikedCharactersDao.deleteDislikedCharacterById(dislikedCharacterDbEntity)

    override fun getDislikedCharacterById(dislikedCharacterId: Int): Single<DislikedCharacterInfoTuple> =
        dislikedCharactersDao.getDislikedCharacterById(dislikedCharacterId)

    override fun deleteAllLikedDislikedCharacters(): Completable =
        Completable.mergeArray(
            likedCharactersDao.deleteAllLikedCharactersFromTable(),
            dislikedCharactersDao.deleteAllDislikedCharactersFromTable()
        )


}