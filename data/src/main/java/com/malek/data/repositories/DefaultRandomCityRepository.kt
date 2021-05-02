package com.malek.data.repositories

import com.malek.data.database.RandomCityDao
import com.malek.data.mappers.RandomCityMapper
import com.malek.data.providers.RandomCityProvider
import com.malek.domain.models.RandomCity
import com.malek.domain.repositories.RandomCityRepository
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.isActive
import javax.inject.Inject
import kotlinx.coroutines.delay as delay

class DefaultRandomCityRepository @Inject constructor (
    private val randomCityProvider: RandomCityProvider,
    private val randomCityDao: RandomCityDao,
    private val randomCityMapper: RandomCityMapper
) : RandomCityRepository {

    companion object {
        private const val NEW_RANDOM_CITY_DELAY_IN_MILLIS = 5000L
    }

    override suspend fun startGeneratingRandomCities(): Flow<RandomCity?> {
        return flow {
            while (currentCoroutineContext().isActive) {
                delay(NEW_RANDOM_CITY_DELAY_IN_MILLIS)
                val randomCity = randomCityProvider.provideRandomCity()
                val randomCityEntity = randomCityMapper.dtoToEntity(randomCity)

                randomCityDao.insertRandomCity(randomCityEntity)
                emit(randomCityMapper.entityToDomain(randomCityEntity))
            }
        }
    }

    override fun getRandomCities(): Flow<List<RandomCity?>> {
        return randomCityDao.getRandomCities()
            .map { randomCityList ->
                randomCityList.map { randomCity ->
                    randomCityMapper.entityToDomain(randomCity)
                }
            }
    }
}