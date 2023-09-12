package com.akkobana.rickandmortyapp.data.model

data class Character(
    private val characterId: Int,
) {
    fun toFavouriteCharacterEntity(): LikedCharacterDbEntity =
        LikedCharacterDbEntity(id = characterId)
    fun toLeastLikedCharacterEntity(): DislikedCharacterDbEntity =
        DislikedCharacterDbEntity(id = characterId)
}