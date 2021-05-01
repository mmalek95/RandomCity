package com.malek.data.providers

import com.malek.data.models.RandomCityDto

interface RandomCityProvider {

    fun provideRandomCity(): RandomCityDto
}