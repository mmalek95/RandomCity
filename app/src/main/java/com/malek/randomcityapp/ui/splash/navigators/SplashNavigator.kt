package com.malek.randomcityapp.ui.splash.navigators

import android.content.Intent
import com.malek.randomcityapp.core.navigators.BaseActivityNavigator
import com.malek.randomcityapp.ui.main.activities.MainActivity
import com.malek.randomcityapp.ui.splash.activities.SplashActivity
import javax.inject.Inject

interface SplashNavigator {

    fun launchMainFlow()
}

class DefaultSplashNavigator @Inject constructor(activity: SplashActivity): BaseActivityNavigator<SplashActivity>(activity), SplashNavigator {

    override fun launchMainFlow() {
        activity?.run {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}