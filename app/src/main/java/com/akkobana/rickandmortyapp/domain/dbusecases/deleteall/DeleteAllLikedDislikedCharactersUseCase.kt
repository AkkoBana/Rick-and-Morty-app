package com.akkobana.rickandmortyapp.domain.dbusecases.deleteall

import kotlinx.coroutines.flow.Flow

interface DeleteAllLikedDislikedCharactersUseCase {
     fun deleteAllLikedDislikedCharacters()
}