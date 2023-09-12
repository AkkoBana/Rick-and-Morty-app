package com.akkobana.rickandmortyapp.domain.dbusecases.deleteall

import io.reactivex.Completable

interface DeleteAllLikedDislikedCharactersUseCase {
    fun deleteAllLikedDislikedCharacters() : Completable
}