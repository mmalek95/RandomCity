package com.malek.data.di

import com.malek.data.mappers.RandomCityMapper
import dagger.Module
import dagger.Provides
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@Module
class MappersModule {

    @Provides
    @Singleton
    fun provideRandomCityMapper(): RandomCityMapper {
        return Mappers.getMapper(RandomCityMapper::class.java)
    }
}