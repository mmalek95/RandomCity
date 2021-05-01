package com.malek.data.providers.impl

import com.malek.data.models.RandomCityDto
import com.malek.data.providers.RandomCityProvider
import kotlin.random.Random

class DefaultRandomCityProvider: RandomCityProvider {

    private val cities = listOf("Gdańsk", "Warszawa", "Poznań")
    private val colors = listOf("Yellow", "Green", "Blue")

    override fun provideRandomCity(): RandomCityDto {
        return RandomCityDto(getRandomCityName(), getRandomColor())
    }

    private fun getRandomCityName(): String? {
        return cities.getOrNull(getRandomNumber(cities.size))
    }

    private fun getRandomColor(): String? {
        return colors.getOrNull(getRandomNumber(colors.size))
    }

    private fun getRandomNumber(until: Int): Int {
        return try {
            Random.nextInt(0, until)
        } catch (exception: IllegalArgumentException) {
            0
        }
    }
}