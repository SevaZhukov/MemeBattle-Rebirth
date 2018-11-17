package com.memebattle.memebattle.core.di.sub.main.module

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.features.main.fragment.profile.data.ApiProfile
import com.memebattle.memebattle.features.main.fragment.profile.domain.interactor.ProfileApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ProfileApiModule {
    @FlowFragmentScope
    @Provides
    fun provideRatingApiService(retrofit: Retrofit): ProfileApiService {
        val api = retrofit.create(ApiProfile::class.java)
        return ProfileApiService(api)
    }
}