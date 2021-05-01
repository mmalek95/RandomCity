package com.malek.randomcityapp.core.di

import com.malek.randomcityapp.ui.main.activities.MainActivity
import com.malek.randomcityapp.ui.main.di.MainActivityFragmentsInjector
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesInjector {

    @ContributesAndroidInjector(modules = [MainActivityFragmentsInjector::class])
    abstract fun provideMainActivity(): MainActivity

}
