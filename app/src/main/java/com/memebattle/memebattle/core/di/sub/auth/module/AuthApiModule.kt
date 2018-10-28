package com.memebattle.memebattle.core.di.sub.auth.module

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.features.auth.core.data.ApiAuth
import com.memebattle.memebattle.features.auth.core.domain.interactor.AuthApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthApiModule {

    @FlowFragmentScope
    @Provides
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService {
        val api = retrofit.create(ApiAuth::class.java)
        return AuthApiService(api)
    }
}