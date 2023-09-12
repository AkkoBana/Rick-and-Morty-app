package com.akkobana.rickandmortyapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "disliked")
data class DislikedCharacterDbEntity (
    @PrimaryKey val id: Int
)