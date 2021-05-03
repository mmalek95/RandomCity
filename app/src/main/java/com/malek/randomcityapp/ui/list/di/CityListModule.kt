package com.malek.randomcityapp.ui.list.di

import com.malek.randomcityapp.ui.list.fragments.CityListFragment
import com.malek.randomcityapp.ui.list.navigators.CityListNavigator
import com.malek.randomcityapp.ui.list.navigators.DefaultCityListNavigator
import dagger.Module
import dagger.Provides

@Module
class CityListModule {

    @Provides
    fun provideCityListNavigator(fragment: CityListFragment): CityListNavigator {
        return DefaultCityListNavigator(fragment)
    }
}