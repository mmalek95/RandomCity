package com.malek.domain.models.wrappers

class Event<T>(val data: T? = null) {

    var wasHandled = false
        private set

    val unhandledData: T?
        get() = if (wasHandled) {
            null
        } else {
            data
        }.also { wasHandled = true }
}

