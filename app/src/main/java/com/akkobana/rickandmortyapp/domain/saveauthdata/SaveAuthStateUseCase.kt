package com.akkobana.rickandmortyapp.domain.saveauthdata

interface SaveAuthStateUseCase {
    fun saveAuthState(state: Boolean)
}