package com.memebattle.memebattle

import android.app.Application
import com.memebattle.memebattle.core.di.core.AppComponent
import com.memebattle.memebattle.core.di.core.DaggerAppComponent
import com.memebattle.memebattle.core.di.sub.auth.AuthComponent
import com.memebattle.memebattle.core.di.sub.auth.module.AuthApiModule
import com.memebattle.memebattle.core.di.sub.auth.module.AuthSettingsModule
import com.memebattle.newlegalclinic.core.di.core.module.AppModule
import com.memebattle.newlegalclinic.core.di.core.module.RetrofitModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
    var authComponent: AuthComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(instance))
                .retrofitModule(RetrofitModule("https://www.memebattle.com/api/"))
                .build()
    }

    fun plusAuthComponent() {
        if (authComponent == null)
            authComponent = appComponent.authComponentBuilder()
                    .apiModule(AuthApiModule())
                    .settingsModule(AuthSettingsModule())
                    .buid()
    }

    fun removeAuthComponent() {
        authComponent = null
    }
}