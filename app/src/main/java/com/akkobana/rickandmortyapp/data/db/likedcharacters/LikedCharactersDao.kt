package com.akkobana.rickandmortyapp.data.db.likedcharacters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface LikedCharactersDao {
    @Insert
    fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity): Completable

    @Query("SELECT id FROM $TABLE_LIKED_NAME")
    fun getAllLikedCharacters(): Single<List<LikedCharacterInfoTuple>>

    @Delete
    fun deleteLikedCharacterById(likedCharacter: LikedCharacterDbEntity): Completable

    @Query("SELECT id FROM $TABLE_LIKED_NAME WHERE id = :likedCharacterId")
    fun getLikedCharacterById(likedCharacterId: Int): Single<LikedCharacterInfoTuple>

    @Query("DELETE FROM $TABLE_LIKED_NAME")
    fun deleteAllLikedCharactersFromTable(): Completable

    companion object {
        const val TABLE_LIKED_NAME = "liked"
    }
}