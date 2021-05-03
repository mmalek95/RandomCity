package com.malek.randomcityapp.ui.list.navigators

import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.malek.domain.models.RandomCity
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.navigators.BaseFragmentNavigator
import com.malek.randomcityapp.ui.details.fragments.RandomCityDetailsFragment.Companion.CITY_COLOR_ARG
import com.malek.randomcityapp.ui.details.fragments.RandomCityDetailsFragment.Companion.CITY_NAME_ARG
import com.malek.randomcityapp.ui.list.fragments.CityListFragment

import javax.inject.Inject

interface CityListNavigator {

    fun openCityDetailsFragment(city: RandomCity)
}

class DefaultCityListNavigator @Inject constructor(fragment: CityListFragment): BaseFragmentNavigator<CityListFragment>(fragment),
    CityListNavigator {

    override fun openCityDetailsFragment(city: RandomCity) {
        if (isDisplayedInLandscapeTablet()) {
            handleLandscapeTabletNavigation(city)
        } else {
            handlePortraitNavigation(city)
        }
    }

    private fun handleLandscapeTabletNavigation(city: RandomCity) {
        if (hasInitialisedNavigationGraph()) {
            changeLandscapeTabletDetailsFragment(city)
        } else {
            createNavigationGraph(city)
        }
    }

    private fun hasInitialisedNavigationGraph(): Boolean {
        return getChildNavHostFragment()?.navController?.currentBackStackEntry != null
    }

    private fun createNavigationGraph(city: RandomCity) {
        val inflater = getChildNavHostFragment()?.navController?.navInflater
        val graph = inflater?.inflate(R.navigation.details_nav_graph)

        graph?.let {
            getChildNavHostFragment()?.navController?.setGraph(graph, createNavArgsFromModel(city))
        }
    }

    private fun changeLandscapeTabletDetailsFragment(city: RandomCity) {
        getChildNavHostFragment()?.navController?.navigate(R.id.randomCityDetailsFragment2, createNavArgsFromModel(city), createNavOptions())
    }

    private fun handlePortraitNavigation(city: RandomCity) {
        val controller = fragment?.view?.findNavController() ?: return

        controller.navigate(R.id.action_cityListFragment_to_randomCityDetailsFragment, createNavArgsFromModel(city), createNavOptions())
    }

    private fun isDisplayedInLandscapeTablet(): Boolean {
        return fragment?.view?.findViewById<View>(R.id.randomCityDetailsContainer) != null
    }

    private fun getChildNavHostFragment(): NavHostFragment? {
        return fragment
            ?.childFragmentManager
            ?.findFragmentById(R.id.randomCityDetailsContainer) as? NavHostFragment
    }

    private fun createNavArgsFromModel(city: RandomCity): Bundle {
        return Bundle().apply {
            putString(CITY_NAME_ARG, city.name)
            putString(CITY_COLOR_ARG, city.color)
        }
    }

    private fun createNavOptions(): NavOptions {
        return NavOptions.Builder().apply {
            setLaunchSingleTop(true)
        }.build()
    }
}