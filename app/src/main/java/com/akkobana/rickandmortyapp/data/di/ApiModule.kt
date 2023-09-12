package com.akkobana.rickandmortyapp.data.di

import android.content.Context
import com.akkobana.rickandmortyapp.data.api.ApiRepository
import com.akkobana.rickandmortyapp.data.api.ApiRepositoryImpl
import com.akkobana.rickandmortyapp.data.api.RickAndMortyApi
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCase
import com.akkobana.rickandmortyapp.domain.getapidata.GetApiResponseUseCaseImpl
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideOkhttpClient(context: Context): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(ChuckerInterceptor.Builder(context).build()).build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_RICK_AND_MORTY)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun provideRickAndMortyApi(retrofit: Retrofit): RickAndMortyApi {
        return retrofit.create(RickAndMortyApi::class.java)
    }

    @Provides
    fun provideApiRepository(rickAndMortyApi: RickAndMortyApi): ApiRepository =
        ApiRepositoryImpl(rickAndMortyApi)

    @Provides
    fun provideGetApiResponseUseCase(apiRepository: ApiRepository): GetApiResponseUseCase =
        GetApiResponseUseCaseImpl(apiRepository)

    companion object {
        const val BASE_URL_RICK_AND_MORTY = "https://rickandmortyapi.com/api/"
    }
}