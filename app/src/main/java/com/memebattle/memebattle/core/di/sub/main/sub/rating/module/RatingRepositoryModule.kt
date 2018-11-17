package com.memebattle.memebattle.core.di.sub.main.sub.rating.module

import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.features.main.fragment.rating.domain.repository.RatingRepository
import dagger.Module
import dagger.Provides

@Module
class RatingRepositoryModule {
    @FragmentScope
    @Provides
    fun provideRepository(): RatingRepository {
        return RatingRepository()
    }
}