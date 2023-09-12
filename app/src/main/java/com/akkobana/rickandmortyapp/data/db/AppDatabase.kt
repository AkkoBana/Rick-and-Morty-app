package com.akkobana.rickandmortyapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akkobana.rickandmortyapp.data.db.dislikedcharacters.DislikedCharactersDao
import com.akkobana.rickandmortyapp.data.db.likedcharacters.LikedCharactersDao
import com.akkobana.rickandmortyapp.data.model.LikedCharacterDbEntity
import com.akkobana.rickandmortyapp.data.model.DislikedCharacterDbEntity

@Database(
    version = 1,
    entities = [
        LikedCharacterDbEntity::class,
        DislikedCharacterDbEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getLikedCharactersDao(): LikedCharactersDao
    abstract fun getDislikedCharactersDao(): DislikedCharactersDao
}