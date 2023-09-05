package com.akkobana.rickandmortyapp.data.di

import android.content.Context
import com.akkobana.rickandmortyapp.data.sharedpref.AuthRepository
import com.akkobana.rickandmortyapp.data.sharedpref.AuthRepositoryImpl
import com.akkobana.rickandmortyapp.data.sharedpref.AuthSharedPref
import com.akkobana.rickandmortyapp.data.sharedpref.AuthSharedPrefImpl
import com.akkobana.rickandmortyapp.domain.getauthdata.GetAuthStateUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetAuthStateUseCaseImpl
import com.akkobana.rickandmortyapp.domain.getauthdata.GetLoginUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetLoginUseCaseImpl
import com.akkobana.rickandmortyapp.domain.getauthdata.GetPasswordUseCase
import com.akkobana.rickandmortyapp.domain.getauthdata.GetPasswordUseCaseImpl
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveAuthStateUseCaseImpl
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveLoginUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SaveLoginUseCaseImpl
import com.akkobana.rickandmortyapp.domain.saveauthdata.SavePasswordUseCase
import com.akkobana.rickandmortyapp.domain.saveauthdata.SavePasswordUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPrefModule {

    @Provides
    fun provideGetLoginUseCase(authRepository: AuthRepository): GetLoginUseCase =
        GetLoginUseCaseImpl(authRepository)

    @Provides
    fun provideSaveLoginUseCase(authRepository: AuthRepository): SaveLoginUseCase =
        SaveLoginUseCaseImpl(authRepository)

    @Provides
    fun provideGetPasswordUseCase(authRepository: AuthRepository): GetPasswordUseCase =
        GetPasswordUseCaseImpl(authRepository)

    @Provides
    fun provideSavePasswordUseCase(authRepository: AuthRepository): SavePasswordUseCase =
        SavePasswordUseCaseImpl(authRepository)

    @Provides
    fun provideAuthRepository(authSharedPref: AuthSharedPref): AuthRepository =
        AuthRepositoryImpl(authSharedPref)

    @Provides
    fun provideGetAuthStateUseCase(authRepository: AuthRepository): GetAuthStateUseCase =
        GetAuthStateUseCaseImpl(authRepository)

    @Provides
    fun provideSaveAuthStateUseCase(authRepository: AuthRepository): SaveAuthStateUseCase =
        SaveAuthStateUseCaseImpl(authRepository)

    @Provides
    fun provideAuthSharedPref(context: Context): AuthSharedPref =
        AuthSharedPrefImpl(context)

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context
}