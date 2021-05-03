package com.malek.randomcityapp.ui.details.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.ui.BaseFragment
import com.malek.randomcityapp.ui.details.navigators.RandomCityDetailsNavigator
import javax.inject.Inject


class RandomCityDetailsFragment: BaseFragment(), OnMapReadyCallback {

    companion object {
        const val CITY_NAME_ARG = "CITY_NAME_ARG"
        const val CITY_COLOR_ARG = "CITY_COLOR_ARG"
    }

    @Inject
    lateinit var navigator: RandomCityDetailsNavigator

    private val cityName: String?
        get() = arguments?.getString(CITY_NAME_ARG)

    private val cityColor: String?
        get() = arguments?.getString(CITY_COLOR_ARG)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator.setupMap(this)
    }

    override fun setupActionBar(actionBar: ActionBar) {
        with(actionBar) {
            title = cityName
            setBackgroundDrawable(ColorDrawable(Color.parseColor(cityColor)))
            setDisplayHomeAsUpEnabled(findNavController().previousBackStackEntry != null)
        }
    }

    override fun onMapReady(map: GoogleMap) {
        val cityAddress = Geocoder(requireContext()).getFromLocationName(cityName, 1)?.getOrNull(0)

        cityAddress?.let {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(it.latitude, it.longitude), 12.0f))
        }
    }
}