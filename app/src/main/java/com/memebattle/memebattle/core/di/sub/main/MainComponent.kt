package com.memebattle.memebattle.core.di.sub.main

import com.memebattle.memebattle.core.di.core.scope.FlowFragmentScope
import com.memebattle.memebattle.core.di.sub.main.module.ProfileApiModule
import com.memebattle.memebattle.core.di.sub.main.sub.game.GameComponent
import com.memebattle.memebattle.core.di.sub.main.sub.rating.RatingComponent
import com.memebattle.memebattle.features.main.fragment.profile.presentation.ProfileViewModel
import dagger.Subcomponent

@Subcomponent(modules = [ProfileApiModule::class])
@FlowFragmentScope
interface MainComponent {
    fun gameComponentBuilder(): GameComponent.Builder
    fun ratingComponentBuilder(): RatingComponent.Builder

    fun inject(profileViewModel: ProfileViewModel)

    @Subcomponent.Builder
    interface Builder {
        fun apiModule(profileApiModule: ProfileApiModule): MainComponent.Builder
        fun buid(): MainComponent
    }
}