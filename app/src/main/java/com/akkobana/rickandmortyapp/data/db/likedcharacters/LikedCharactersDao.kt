package com.akkobana.rickandmortyapp.data.db.likedcharacters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LikedCharactersDao {
    @Insert
    suspend fun insertNewLikedCharacter(likedCharacter: LikedCharacterDbEntity)

    @Query("SELECT id FROM $TABLE_LIKED_NAME")
    fun getAllLikedCharacters(): Flow<List<LikedCharacterInfoTuple>>
    @Delete
    suspend fun deleteLikedCharacterById(likedCharacter: LikedCharacterDbEntity)

    @Query("SELECT id FROM $TABLE_LIKED_NAME WHERE id = :likedCharacterId")
    fun getLikedCharacterById(likedCharacterId: Int): Flow<LikedCharacterInfoTuple>

    @Query("DELETE FROM $TABLE_LIKED_NAME")
    fun deleteAllLikedCharactersFromTable()

    companion object {
        const val TABLE_LIKED_NAME = "liked"
    }
}