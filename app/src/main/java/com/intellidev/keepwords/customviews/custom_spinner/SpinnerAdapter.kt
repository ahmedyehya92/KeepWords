package com.intellidev.keepwords.customviews.custom_spinner

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.support.annotation.StringRes
import android.util.Log

open class SpinnerAdapter<T> (
    lifecycleOwner: LifecycleOwner,
    list: MutableLiveData<MutableList<T>>,
    aContext: Context? = null,
    @StringRes private val  hint: Int
    ): CustomeHintSpinnerAdapter<T>(aContext!!,list.value!!,hint)

{

init {
    list.observe(lifecycleOwner, Observer {
        //notifyDataSetChanged()
        addAll(it)
        Log.i("", it!!.size.toString())
    })

}

}
