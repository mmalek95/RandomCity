package com.malek.randomcityapp.ui.details.di

import com.malek.randomcityapp.ui.details.fragments.RandomCityDetailsFragment
import com.malek.randomcityapp.ui.details.navigators.DefaultRandomCityDetailsNavigator
import com.malek.randomcityapp.ui.details.navigators.RandomCityDetailsNavigator
import dagger.Module
import dagger.Provides

@Module
class CityDetailsModule {

    @Provides
    fun provideRandomCityDetailsNavigator(fragment: RandomCityDetailsFragment): RandomCityDetailsNavigator {
        return DefaultRandomCityDetailsNavigator(fragment)
    }
}