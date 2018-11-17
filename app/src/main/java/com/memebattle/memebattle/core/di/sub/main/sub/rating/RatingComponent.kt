package com.memebattle.memebattle.core.di.sub.main.sub.rating

import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.core.di.sub.main.sub.rating.module.RatingApiModule
import com.memebattle.memebattle.core.di.sub.main.sub.rating.module.RatingRepositoryModule
import com.memebattle.memebattle.core.di.sub.main.sub.rating.module.RatingRoomModule
import com.memebattle.memebattle.features.main.fragment.rating.data.paging.RatingPositionalDataSource
import com.memebattle.memebattle.features.main.fragment.rating.domain.repository.RatingRepository
import dagger.Subcomponent

@Subcomponent(modules = [RatingApiModule::class, RatingRoomModule::class, RatingRepository::class])
@FragmentScope
interface RatingComponent {
    fun inject(ratingPositionalDataSource: RatingPositionalDataSource)
    fun inject(ratingRepository: RatingRepository)

    @Subcomponent.Builder
    interface Builder {
        fun apiModule(ratingApiModule: RatingApiModule): Builder
        fun roomModule(ratingRoomModule: RatingRoomModule): Builder
        fun repositoryModule(ratingRepositoryModule: RatingRepositoryModule): Builder
        fun buid(): RatingComponent
    }
}