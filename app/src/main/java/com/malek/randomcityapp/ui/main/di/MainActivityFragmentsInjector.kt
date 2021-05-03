package com.malek.randomcityapp.ui.main.di

import com.malek.randomcityapp.ui.details.di.CityDetailsModule
import com.malek.randomcityapp.ui.details.fragments.RandomCityDetailsFragment
import com.malek.randomcityapp.ui.list.di.CityListModule
import com.malek.randomcityapp.ui.list.fragments.CityListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsInjector {

    @ContributesAndroidInjector(modules = [CityListModule::class])
    abstract fun provideCityListFragment(): CityListFragment

    @ContributesAndroidInjector(modules = [CityDetailsModule::class])
    abstract fun provideRandomCityDetailsFragment(): RandomCityDetailsFragment

}