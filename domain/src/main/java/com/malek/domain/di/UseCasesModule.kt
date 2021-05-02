package com.malek.domain.di

import com.malek.domain.repositories.RandomCityRepository
import com.malek.domain.usecases.GetRandomCitiesUseCase
import com.malek.domain.usecases.GenerateRandomCitiesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideGetRandomCitiesUseCase(randomCityRepository: RandomCityRepository): GetRandomCitiesUseCase {
        return GetRandomCitiesUseCase(randomCityRepository)
    }

    @Provides
    fun provideGenerateRandomCitiesUseCase(randomCityRepository: RandomCityRepository): GenerateRandomCitiesUseCase {
        return GenerateRandomCitiesUseCase(randomCityRepository)
    }
}