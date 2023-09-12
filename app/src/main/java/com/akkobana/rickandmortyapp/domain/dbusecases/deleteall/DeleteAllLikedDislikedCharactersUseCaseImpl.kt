package com.akkobana.rickandmortyapp.domain.dbusecases.deleteall

import com.akkobana.rickandmortyapp.data.db.DataBaseRepository
import io.reactivex.Completable
import javax.inject.Inject

class DeleteAllLikedDislikedCharactersUseCaseImpl @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
): DeleteAllLikedDislikedCharactersUseCase {
    override fun deleteAllLikedDislikedCharacters(): Completable =
        dataBaseRepository.deleteAllLikedDislikedCharacters()
}