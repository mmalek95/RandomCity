package com.malek.data.providers.impl

import com.malek.data.models.dtos.RandomCityDto
import com.malek.data.providers.RandomCityProvider
import com.malek.data.utils.DateUtils
import kotlin.random.Random

class DefaultRandomCityProvider: RandomCityProvider {

    private val cities = listOf("Gdańsk", "Warszawa", "Poznań", "Białystok", "Wrocław", "Katowice", "Kraków")
    private val colors = listOf("Yellow", "Green", "Blue", "Red", "Black", "White")

    override fun provideRandomCity(): RandomCityDto {
        return RandomCityDto(
            getRandomCityName(),
            getRandomColor(),
            DateUtils.getCurrentTimeStampInMillis()
        )
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