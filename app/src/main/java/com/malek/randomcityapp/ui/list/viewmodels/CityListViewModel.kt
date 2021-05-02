package com.malek.randomcityapp.ui.list.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.malek.domain.usecases.GetRandomCitiesUseCase
import javax.inject.Inject

class CityListViewModel @Inject constructor(getRandomCitiesUseCase: GetRandomCitiesUseCase): ViewModel() {

    val randomCities = getRandomCitiesUseCase.getRandomCities().asLiveData()
}