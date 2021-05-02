package com.malek.domain.repositories

import com.malek.domain.models.RandomCity
import kotlinx.coroutines.flow.Flow

interface RandomCityRepository {

    suspend fun startGeneratingRandomCities(): Flow<RandomCity?>

    fun getRandomCities(): Flow<List<RandomCity?>>
}