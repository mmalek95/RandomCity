package com.malek.randomcityapp.core.app

import com.malek.randomcityapp.core.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class RandomCityApplication: DaggerApplication() {

    private lateinit var component: AndroidInjector<RandomCityApplication>

    override fun applicationInjector(): AndroidInjector<RandomCityApplication> {
        if (!::component.isInitialized) {
            component = DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
        }
        return component
    }
}