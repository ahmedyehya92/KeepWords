package com.intellidev.usecases.engine

import android.arch.lifecycle.MutableLiveData

fun <T> T.toMutableLiveData(): MutableLiveData<T> {
    return MutableLiveData<T>()
        .also { it.value = this }
}