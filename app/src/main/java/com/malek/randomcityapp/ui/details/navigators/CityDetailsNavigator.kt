package com.malek.randomcityapp.ui.details.navigators

import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.navigators.BaseFragmentNavigator
import com.malek.randomcityapp.ui.details.fragments.RandomCityDetailsFragment
import javax.inject.Inject

interface RandomCityDetailsNavigator {

    fun setupMap(callback: OnMapReadyCallback)
}

class DefaultRandomCityDetailsNavigator @Inject constructor(fragment: RandomCityDetailsFragment): BaseFragmentNavigator<RandomCityDetailsFragment>(fragment),
    RandomCityDetailsNavigator {

    override fun setupMap(callback: OnMapReadyCallback) {
        val mapFragment = fragment
            ?.childFragmentManager
            ?.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(callback)
    }

}