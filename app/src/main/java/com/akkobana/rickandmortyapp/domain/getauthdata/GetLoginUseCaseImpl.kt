package com.akkobana.rickandmortyapp.domain.getauthdata

import com.akkobana.rickandmortyapp.data.AuthRepository
import javax.inject.Inject

class GetLoginUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : GetLoginUseCase {
    override fun getLogin(): String = authRepository.getLogin()
}