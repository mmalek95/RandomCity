package com.malek.randomcityapp.ui.list.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.ui.BaseFragment
import com.malek.randomcityapp.ui.list.viewmodels.CityListViewModel
import kotlinx.android.synthetic.main.fragment_city_list.*

import javax.inject.Inject

class CityListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CityListViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    val str = StringBuilder()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLiveDataObservers()
    }

    private fun initLiveDataObservers() {
        viewModel.randomCities.observe(viewLifecycleOwner, Observer {
            it.forEach {
                str.append(it?.name.orEmpty() + " ")
            }

            randomCityTextView.text = str.toString()
            str.clear()
        })
    }

}