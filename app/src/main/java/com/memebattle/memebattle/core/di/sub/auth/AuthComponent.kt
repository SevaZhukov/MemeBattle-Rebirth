package com.memebattle.memebattle.core.di.sub.auth

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.core.di.sub.auth.module.AuthApiModule
import com.memebattle.memebattle.core.di.sub.auth.module.AuthSettingsModule
import dagger.Subcomponent

@Subcomponent(modules = [AuthApiModule::class, AuthSettingsModule::class])
@FlowFragmentScope
interface AuthComponent {
    @Subcomponent.Builder
    interface Builder {
        fun apiModule(authApiModule: AuthApiModule): AuthComponent.Builder
        fun settingsModule(authSettingsModule: AuthSettingsModule): AuthComponent.Builder
        fun buid(): AuthComponent
    }
}