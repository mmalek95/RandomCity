package com.malek.data.utils

import java.util.*

object DateUtils {

    fun getCurrentTimeStampInMillis(): Long {
        return Calendar.getInstance(Locale.getDefault()).timeInMillis
    }
}