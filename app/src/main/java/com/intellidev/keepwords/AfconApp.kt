package com.intellidev.keepwords

import android.app.Application
import com.intellidev.usecases.Domain

class AfconApp: Application() {
    private lateinit var instance: AfconApp

    override fun onCreate() {
        super.onCreate()
        instance = this
        Domain.integrateWith(this)

    }

    fun getInstance(): AfconApp {
        return instance
    }


}