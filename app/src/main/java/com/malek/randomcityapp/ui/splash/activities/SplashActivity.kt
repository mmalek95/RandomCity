package com.malek.randomcityapp.ui.splash.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.ui.BaseActivity
import com.malek.randomcityapp.ui.main.activities.MainActivity
import com.malek.randomcityapp.ui.splash.viewmodels.SplashViewModel

import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SplashViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initLiveDataObservers()
        viewModel.generateRandomCity()
    }

    private fun initLiveDataObservers() {
        viewModel.finishSplashEvent.observe(this, Observer { newCityEvent ->
            newCityEvent?.unhandledData?.let {
                val intent = Intent(this, MainActivity::class.java).apply {
                    finish()
                }

                startActivity(intent)
            }
        })
    }

}