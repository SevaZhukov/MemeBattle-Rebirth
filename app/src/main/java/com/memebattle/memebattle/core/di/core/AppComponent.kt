package com.memebattle.memebattle.core.di.core

import com.memebattle.memebattle.core.di.core.module.RoomModule
import com.memebattle.memebattle.core.di.sub.auth.AuthComponent
import com.memebattle.memebattle.core.di.sub.main.MainComponent
import com.memebattle.memebattle.features.auth.fragment.sign_in.SignInViewModel
import com.memebattle.newlegalclinic.core.di.core.module.AppModule
import com.memebattle.newlegalclinic.core.di.core.module.RetrofitModule
import com.memebattle.newlegalclinic.core.di.core.module.SharedPreferencesModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, SharedPreferencesModule::class, RoomModule::class])
interface AppComponent {
    fun authComponentBuilder(): AuthComponent.Builder
    fun mainComponentBuilder(): MainComponent.Builder
}