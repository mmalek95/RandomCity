package com.malek.randomcityapp.core.di

import com.malek.randomcityapp.ui.main.activities.MainActivity
import com.malek.randomcityapp.ui.main.di.MainActivityFragmentsInjector
import com.malek.randomcityapp.ui.splash.activities.SplashActivity
import com.malek.randomcityapp.ui.splash.di.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesInjector {

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun provideSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [MainActivityFragmentsInjector::class])
    abstract fun provideMainActivity(): MainActivity

}
