package com.memebattle.memebattle.core.di.core

import com.memebattle.memebattle.core.di.sub.auth.AuthComponent
import com.memebattle.newlegalclinic.core.di.core.module.AppModule
import com.memebattle.newlegalclinic.core.di.core.module.RetrofitModule
import com.memebattle.newlegalclinic.core.di.core.module.SharedPreferencesModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun authComponentBuilder(): AuthComponent.Builder
}