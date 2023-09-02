package com.akkobana.rickandmortyapp.domain.getauthdata

import com.akkobana.rickandmortyapp.data.AuthRepository
import javax.inject.Inject

class GetPasswordUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : GetPasswordUseCase {
    override fun getPassword(): String  = authRepository.getPassword()
}