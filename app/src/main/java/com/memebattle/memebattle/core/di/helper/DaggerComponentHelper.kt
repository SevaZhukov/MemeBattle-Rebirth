package com.memebattle.memebattle.core.di.helper

import com.memebattle.memebattle.App
import com.memebattle.memebattle.core.di.core.DaggerAppComponent
import com.memebattle.memebattle.core.di.sub.auth.AuthComponent
import com.memebattle.memebattle.core.di.sub.auth.module.AuthApiModule
import com.memebattle.memebattle.core.di.sub.auth.module.AuthSettingsModule
import com.memebattle.memebattle.core.di.sub.main.MainComponent
import com.memebattle.memebattle.core.di.sub.main.module.RatingApiModule
import com.memebattle.memebattle.core.di.sub.main.sub.game.GameComponent
import com.memebattle.memebattle.core.di.sub.main.sub.game.module.GameSocketModule
import com.memebattle.newlegalclinic.core.di.core.module.AppModule
import com.memebattle.newlegalclinic.core.di.core.module.RetrofitModule

class DaggerComponentHelper(url: String, private val socketUrl: String) {

    private val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(App.instance))
            .retrofitModule(RetrofitModule(url))
            .build()

    var authComponent: AuthComponent? = null
    var mainComponent: MainComponent? = null
    var gameComponent: GameComponent? = null

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

    fun plusMainComponent() {
        if (mainComponent == null)
            mainComponent = appComponent.mainComponentBuilder()
                    .apiModule(RatingApiModule())
                    .buid()
    }

    fun removeMainComponent() {
        mainComponent = null
    }

    fun plusGameComponent() {
        if (gameComponent == null)
            gameComponent = mainComponent!!.gameComponentBuilder()
                    .socketModule(GameSocketModule(socketUrl))
                    .buid()
    }

    fun removeGameComponent() {
        gameComponent = null
    }
}