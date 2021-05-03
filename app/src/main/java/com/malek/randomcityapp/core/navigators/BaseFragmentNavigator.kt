package com.malek.randomcityapp.core.navigators


import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

abstract class BaseFragmentNavigator<T : Fragment>(fragment: T) {

    private val weakFragment = WeakReference(fragment)

    protected val fragment
        get() = weakFragment.get()
}