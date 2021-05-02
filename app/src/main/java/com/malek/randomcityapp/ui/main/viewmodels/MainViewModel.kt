package com.malek.randomcityapp.ui.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malek.domain.usecases.GenerateRandomCitiesUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val generateRandomCitiesUseCase: GenerateRandomCitiesUseCase): ViewModel() {

    private var randomCitiesGenerationJob: Job? = null

    fun startGeneratingRandomCities() {
        if (randomCitiesGenerationJob?.isActive == true) return

        randomCitiesGenerationJob = viewModelScope.launch {
            generateRandomCitiesUseCase
                .startGeneratingRandomCities()
                .collect()
        }
    }

    fun stopGeneratingRandomCities() {
        randomCitiesGenerationJob?.cancel()
        randomCitiesGenerationJob = null
    }
}