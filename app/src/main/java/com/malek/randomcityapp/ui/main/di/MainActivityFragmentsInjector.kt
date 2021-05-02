package com.malek.randomcityapp.ui.main.di

import com.malek.randomcityapp.ui.list.fragments.CityListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsInjector {

    @ContributesAndroidInjector(modules = [])
    abstract fun provideCityListFragment(): CityListFragment
}