package com.malek.randomcityapp.ui.list.binding

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.malek.domain.models.RandomCity
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("cityColor")
fun cityColor(view: TextView, city: RandomCity) {
    city.color?.let { color ->
        view.setTextColor(Color.parseColor(color))
    }
}

@BindingAdapter("cityCreationDate")
fun cityCreationDate(view: TextView, city: RandomCity) {
    val dateFormat = SimpleDateFormat("dd/MM/yyy hh:mm:ss", Locale.getDefault())
    view.text = dateFormat.format(city.creationTimeStampInMillis)
}