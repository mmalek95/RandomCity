package com.malek.randomcityapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.malek.data.providers.RandomCityProvider
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_city_list.*
import javax.inject.Inject

class CityListFragment : BaseFragment() {

    @Inject
    lateinit var randomCityProvider: RandomCityProvider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomCityTextView.text = randomCityProvider.provideRandomCity().name
    }

}