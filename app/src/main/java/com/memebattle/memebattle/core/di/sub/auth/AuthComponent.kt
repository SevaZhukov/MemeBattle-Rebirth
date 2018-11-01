package com.memebattle.memebattle.core.di.sub.auth

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.core.di.sub.auth.module.AuthApiModule
import com.memebattle.memebattle.core.di.sub.auth.module.AuthSettingsModule
import com.memebattle.memebattle.features.auth.fragment.sign_in.SignInViewModel
import com.memebattle.memebattle.features.auth.fragment.sign_up.SignUpViewModel
import com.memebattle.memebattle.features.auth.fragment.vk.VkViewModel
import dagger.Subcomponent

@Subcomponent(modules = [AuthApiModule::class, AuthSettingsModule::class])
@FlowFragmentScope
interface AuthComponent {
    fun inject(signInViewModel: SignInViewModel)
    fun inject(vkViewModel: VkViewModel)
    fun inject(signUpViewModel: SignUpViewModel)

    @Subcomponent.Builder
    interface Builder {
        fun apiModule(authApiModule: AuthApiModule): AuthComponent.Builder
        fun settingsModule(authSettingsModule: AuthSettingsModule): AuthComponent.Builder
        fun buid(): AuthComponent
    }
}