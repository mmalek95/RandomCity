package com.malek.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.malek.data.models.entities.RandomCityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RandomCityDao {

    @Insert
    suspend fun insertRandomCity(randomCityEntity: RandomCityEntity?)

    @Query("SELECT * FROM RandomCityEntity")
    fun getRandomCities(): Flow<List<RandomCityEntity?>>

}