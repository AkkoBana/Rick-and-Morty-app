package com.akkobana.rickandmortyapp.domain.getauthdata

import com.akkobana.rickandmortyapp.data.AuthRepository
import javax.inject.Inject

class GetAuthStateUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
): GetAuthStateUseCase {
    override fun getAuthState(): Boolean =
        authRepository.getAuthState()
}