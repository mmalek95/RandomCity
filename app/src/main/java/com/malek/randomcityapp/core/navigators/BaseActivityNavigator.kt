package com.malek.randomcityapp.core.navigators

import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

abstract class BaseActivityNavigator<T : AppCompatActivity>(activity: T) {

    private val weakActivity = WeakReference(activity)

    protected val activity
        get() = weakActivity.get()
}