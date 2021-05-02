package com.malek.data.di

import android.content.Context
import androidx.room.Room
import com.malek.data.database.RandomCityDao
import com.malek.data.database.RandomCityDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): RandomCityDatabase {
        return Room
            .databaseBuilder(context, RandomCityDatabase::class.java, RandomCityDatabase.DB_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideRandomCitiesDao(database: RandomCityDatabase): RandomCityDao {
        return database.getRandomCityDao()
    }
}