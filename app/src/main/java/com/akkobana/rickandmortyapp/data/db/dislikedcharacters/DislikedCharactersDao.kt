package com.akkobana.rickandmortyapp.data.db.dislikedcharacters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DislikedCharactersDao {
    @Insert
    suspend fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity)

    @Query("SELECT id FROM $TABLE_DISLIKED_NAME")
    fun getDislikedCharacters(): Flow<List<DislikedCharacterInfoTuple>>

    @Delete
    suspend fun deleteDislikedCharacterById(dislikedCharacterDbEntity: DislikedCharacterDbEntity)

    @Query("SELECT id FROM $TABLE_DISLIKED_NAME WHERE id = :dislikedCharacterId")
    fun getDislikedCharacterById(dislikedCharacterId: Int): Flow<DislikedCharacterInfoTuple>

    @Query("DELETE FROM $TABLE_DISLIKED_NAME")
    fun deleteAllDislikedCharactersFromTable()
    companion object{
        const val TABLE_DISLIKED_NAME = "disliked"
    }
}