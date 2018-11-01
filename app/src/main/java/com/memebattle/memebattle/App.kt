package com.memebattle.memebattle

import android.app.Application
import com.memebattle.memebattle.core.di.helper.DaggerComponentHelper

class App : Application() {
    lateinit var daggerComponentHelper: DaggerComponentHelper

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        daggerComponentHelper = DaggerComponentHelper(resources.getString(R.string.url))
    }
}