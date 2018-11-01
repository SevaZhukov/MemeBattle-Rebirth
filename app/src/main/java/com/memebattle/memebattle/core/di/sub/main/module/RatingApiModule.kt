package com.memebattle.memebattle.core.di.sub.main.module

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.features.main.fragment.rating.data.ApiRating
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RatingApiModule {
    @FlowFragmentScope
    @Provides
    fun provideRatingApiService(retrofit: Retrofit): RatingApiService {
        val api = retrofit.create(ApiRating::class.java)
        return RatingApiService(api)
    }
}