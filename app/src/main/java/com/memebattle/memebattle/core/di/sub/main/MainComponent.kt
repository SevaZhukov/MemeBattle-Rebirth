package com.memebattle.memebattle.core.di.sub.main

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.core.di.sub.main.module.RatingApiModule
import com.memebattle.memebattle.features.main.fragment.rating.presentation.RatingViewModel
import dagger.Subcomponent

@Subcomponent(modules = [RatingApiModule::class])
@FlowFragmentScope
interface MainComponent {
    fun inject(ratingViewModel: RatingViewModel)

    @Subcomponent.Builder
    interface Builder {
        fun apiModule(ratingApiModule: RatingApiModule): MainComponent.Builder
        fun buid(): MainComponent
    }
}