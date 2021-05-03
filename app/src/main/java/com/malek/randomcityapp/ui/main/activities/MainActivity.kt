package com.malek.randomcityapp.ui.main.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.malek.randomcityapp.R
import com.malek.randomcityapp.core.ui.BaseActivity
import com.malek.randomcityapp.ui.main.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        viewModel.startGeneratingRandomCities()
    }

    override fun onPause() {
        super.onPause()

        viewModel.stopGeneratingRandomCities()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> false
        }
    }
}