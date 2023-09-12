package com.akkobana.rickandmortyapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liked")
data class LikedCharacterDbEntity(
    @PrimaryKey(autoGenerate = false) val id: Int
)