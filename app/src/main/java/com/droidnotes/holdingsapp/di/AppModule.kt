package com.droidnotes.holdingsapp.di

import com.droidnotes.holdingsapp.data.remote.HoldingsApi
import com.droidnotes.holdingsapp.data.repository.HoldingsRepositoryImpl
import com.droidnotes.holdingsapp.domain.repository.HoldingsRepository
import com.droidnotes.holdingsapp.domain.usecase.PortfolioUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): HoldingsApi = Retrofit.Builder()
        .baseUrl("https://35dee773a9ec441e9f38d5fc249406ce.api.mockbin.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HoldingsApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: HoldingsApi): HoldingsRepository =
        HoldingsRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideUseCase(): PortfolioUseCase = PortfolioUseCase()
}