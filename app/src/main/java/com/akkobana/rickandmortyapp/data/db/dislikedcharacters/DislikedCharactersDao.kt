package com.akkobana.rickandmortyapp.data.db.dislikedcharacters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface DislikedCharactersDao {
    @Insert
    fun insertNewDislikedCharacter(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable

    @Query("SELECT id FROM $TABLE_DISLIKED_NAME")
    fun getDislikedCharacters(): Single<List<DislikedCharacterInfoTuple>>

    @Delete
    fun deleteDislikedCharacterById(dislikedCharacterDbEntity: DislikedCharacterDbEntity): Completable

    @Query("SELECT id FROM $TABLE_DISLIKED_NAME WHERE id = :dislikedCharacterId")
    fun getDislikedCharacterById(dislikedCharacterId: Int): Single<DislikedCharacterInfoTuple>

    @Query("DELETE FROM $TABLE_DISLIKED_NAME")
    fun deleteAllDislikedCharactersFromTable(): Completable
    companion object{
        const val TABLE_DISLIKED_NAME = "disliked"
    }
}