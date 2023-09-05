package com.akkobana.rickandmortyapp.domain.saveauthdata

import com.akkobana.rickandmortyapp.data.sharedpref.AuthRepository
import javax.inject.Inject

class SaveLoginUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) :
    SaveLoginUseCase {
    override fun saveLogin(login: String) {
        authRepository.saveLogin(login)
    }
}