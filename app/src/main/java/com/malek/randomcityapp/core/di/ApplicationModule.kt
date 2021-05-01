package com.malek.randomcityapp.core.di

import android.content.Context
import com.malek.randomcityapp.core.app.RandomCityApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: RandomCityApplication): Context {
        return application
    }
}
