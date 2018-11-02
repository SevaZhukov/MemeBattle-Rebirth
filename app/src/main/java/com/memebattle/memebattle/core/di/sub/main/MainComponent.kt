package com.memebattle.memebattle.core.di.sub.main

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.core.di.sub.main.module.RatingApiModule
import com.memebattle.memebattle.core.di.sub.main.sub.game.GameComponent
import com.memebattle.memebattle.features.main.fragment.profile.presentation.ProfileViewModel
import com.memebattle.memebattle.features.main.fragment.rating.presentation.RatingViewModel
import dagger.Subcomponent

@Subcomponent(modules = [RatingApiModule::class])
@FlowFragmentScope
interface MainComponent {
    fun gameComponentBuilder(): GameComponent.Builder

    fun inject(ratingViewModel: RatingViewModel)
    fun inject(profileViewModel: ProfileViewModel)

    @Subcomponent.Builder
    interface Builder {
        fun apiModule(ratingApiModule: RatingApiModule): MainComponent.Builder
        fun buid(): MainComponent
    }
}