package com.malek.data.providers

import com.malek.data.models.dtos.RandomCityDto

interface RandomCityProvider {

    fun provideRandomCity(): RandomCityDto
}