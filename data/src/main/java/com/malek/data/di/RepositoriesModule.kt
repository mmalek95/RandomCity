package com.malek.data.di

import com.malek.data.database.RandomCityDao
import com.malek.data.mappers.RandomCityMapper
import com.malek.data.providers.RandomCityProvider
import com.malek.data.providers.impl.DefaultRandomCityProvider
import com.malek.data.repositories.DefaultRandomCityRepository
import com.malek.domain.repositories.RandomCityRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideRandomCityRepository(
        randomCityProvider: RandomCityProvider,
        randomCityDao: RandomCityDao,
        randomCityMapper: RandomCityMapper
    ): RandomCityRepository {
        return DefaultRandomCityRepository(randomCityProvider, randomCityDao, randomCityMapper)
    }
}