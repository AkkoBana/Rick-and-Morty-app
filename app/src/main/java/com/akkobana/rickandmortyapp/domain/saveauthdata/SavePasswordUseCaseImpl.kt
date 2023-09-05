package com.akkobana.rickandmortyapp.domain.saveauthdata

import com.akkobana.rickandmortyapp.data.sharedpref.AuthRepository
import javax.inject.Inject

class SavePasswordUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : SavePasswordUseCase {
    override fun savePassword(password: String) {
        authRepository.savePassword(password)
    }
}