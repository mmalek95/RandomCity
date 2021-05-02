package com.malek.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.malek.data.models.entities.RandomCityEntity

@Database(entities = [RandomCityEntity::class], version = 1, exportSchema = false)
abstract class RandomCityDatabase: RoomDatabase() {

    abstract fun getRandomCityDao(): RandomCityDao

    companion object {
        const val DB_NAME = "randomCityDatabase"
    }
}