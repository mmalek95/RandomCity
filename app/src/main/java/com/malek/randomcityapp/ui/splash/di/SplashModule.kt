package com.malek.randomcityapp.ui.splash.di

import com.malek.randomcityapp.ui.splash.activities.SplashActivity
import com.malek.randomcityapp.ui.splash.navigators.DefaultSplashNavigator
import com.malek.randomcityapp.ui.splash.navigators.SplashNavigator
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    fun provideSplashNavigator(activity: SplashActivity): SplashNavigator {
        return DefaultSplashNavigator(activity)
    }
}