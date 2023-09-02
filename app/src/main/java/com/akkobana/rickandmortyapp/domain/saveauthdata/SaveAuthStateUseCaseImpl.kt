package com.akkobana.rickandmortyapp.domain.saveauthdata

import com.akkobana.rickandmortyapp.data.AuthRepository
import javax.inject.Inject

class SaveAuthStateUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
): SaveAuthStateUseCase {
    override fun saveAuthState(state: Boolean) {
        authRepository.saveAuthState(state)
    }

}