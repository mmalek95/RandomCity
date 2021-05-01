package com.malek.data.di

import com.malek.data.providers.RandomCityProvider
import com.malek.data.providers.impl.DefaultRandomCityProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProvidersModule {

    @Provides
    @Singleton
    fun provideRandomCityProvider(): RandomCityProvider {
        return DefaultRandomCityProvider()
    }
}