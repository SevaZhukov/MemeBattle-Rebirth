package com.memebattle.memebattle.core.di.sub.main.sub.rating.module

import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.features.main.fragment.rating.data.api.ApiRating
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RatingApiModule {
    @FragmentScope
    @Provides
    fun provideRatingApiService(retrofit: Retrofit): RatingApiService {
        val api = retrofit.create(ApiRating::class.java)
        return RatingApiService(api)
    }
}