package com.malek.randomcityapp.ui.splash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malek.domain.models.RandomCity
import com.malek.domain.models.wrappers.Event
import com.malek.domain.usecases.GenerateRandomCitiesUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val generateRandomCitiesUseCase: GenerateRandomCitiesUseCase): ViewModel() {

    private val _finishSplashEvent = MutableLiveData<Event<RandomCity>>()
    val finishSplashEvent: LiveData<Event<RandomCity>> = _finishSplashEvent

    init {
        generateRandomCity()
    }

    private fun generateRandomCity() {
        viewModelScope.launch {
            generateRandomCitiesUseCase
                .startGeneratingRandomCities()
                .take(1)
                .collect { city ->
                    if (city != null) {
                        _finishSplashEvent.value = Event(city)
                    }
                }
        }
    }
}