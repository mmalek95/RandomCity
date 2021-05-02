package com.malek.domain.usecases

import com.malek.domain.models.RandomCity
import com.malek.domain.repositories.RandomCityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GenerateRandomCitiesUseCase @Inject constructor(private val randomCityRepository: RandomCityRepository) {

    suspend fun startGeneratingRandomCities(): Flow<RandomCity?> {
        return randomCityRepository.startGeneratingRandomCities()
    }
}