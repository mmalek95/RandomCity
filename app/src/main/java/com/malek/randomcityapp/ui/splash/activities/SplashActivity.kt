package com.malek.randomcityapp.ui.splash.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.ui.BaseActivity
import com.malek.randomcityapp.ui.splash.navigators.SplashNavigator
import com.malek.randomcityapp.ui.splash.viewmodels.SplashViewModel

import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SplashViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var navgator: SplashNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initLiveDataObservers()
    }

    private fun initLiveDataObservers() {
        viewModel.finishSplashEvent.observe(this, Observer { newCityEvent ->
            newCityEvent?.unhandledData?.let {
                navgator.launchMainFlow()
            }
        })
    }

}