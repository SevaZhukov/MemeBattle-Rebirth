package com.memebattle.memebattle.core.di.sub.auth.module

import android.content.SharedPreferences
import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.newlegalclinic.feature.auth.core.domain.AuthSettingsService
import dagger.Module
import dagger.Provides

@Module
class AuthSettingsModule {
    @FlowFragmentScope
    @Provides
    fun provideAuthSettingsService(sharedPreferences: SharedPreferences): AuthSettingsService {
        return AuthSettingsService(sharedPreferences)
    }
}