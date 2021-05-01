package com.malek.data.providers.impl

import com.malek.data.models.RandomCityDto
import com.malek.data.providers.RandomCityProvider

class DefaultRandomCityProvider: RandomCityProvider {

    override fun provideRandomCity(): RandomCityDto {
        return RandomCityDto("test random city")
    }
}