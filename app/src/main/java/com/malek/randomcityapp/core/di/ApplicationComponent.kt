package com.malek.randomcityapp.core.di

import com.malek.data.di.DatabaseModule
import com.malek.data.di.MappersModule
import com.malek.data.di.ProvidersModule
import com.malek.data.di.RepositoriesModule
import com.malek.randomcityapp.core.app.RandomCityApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        //application
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivitiesInjector::class,
        ViewModelModule::class,
        //domain
        //data
        DatabaseModule::class,
        ProvidersModule::class,
        RepositoriesModule::class,
        MappersModule::class
    ]
)
interface ApplicationComponent: AndroidInjector<RandomCityApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: RandomCityApplication): Builder

        fun build(): ApplicationComponent
    }
}