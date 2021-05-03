package com.malek.randomcityapp.core.ui

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.malek.randomcityapp.R
import dagger.android.support.DaggerFragment

open class BaseFragment: DaggerFragment() {

    protected val baseActivity: BaseActivity
        get() = activity as BaseActivity

    override fun onStart() {
        super.onStart()

        baseActivity.supportActionBar?.let { actionBar ->
            setupActionBar(actionBar)
        }
    }

    protected open fun setupActionBar(actionBar: ActionBar) = clearActionBar(actionBar)

    private fun clearActionBar(actionBar: ActionBar) {
        with(actionBar) {
            title = getString(R.string.app_name)
            setDisplayHomeAsUpEnabled(false)
            setBackgroundDrawable(getDefaultActionbarColor())
        }
    }

    private fun getDefaultActionbarColor(): ColorDrawable {
        return ColorDrawable(ContextCompat.getColor(requireContext(), R.color.purple_500))
    }
}