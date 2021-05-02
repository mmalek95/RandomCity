package com.malek.domain.usecases

import com.malek.domain.models.RandomCity
import com.malek.domain.repositories.RandomCityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class GetRandomCitiesUseCase constructor(private val randomCityRepository: RandomCityRepository) {

    fun getRandomCities(): Flow<List<RandomCity?>> {
        return randomCityRepository
            .getRandomCities()
            .onEach(this::sortByName)
    }

    private fun sortByName(randomCities: List<RandomCity?>): List<RandomCity?> {
        return randomCities.sortedBy { it?.name }
    }
}