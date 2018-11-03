package com.memebattle.memebattle.core.di.sub.main.sub.game

import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.core.di.sub.main.sub.game.module.GameSocketModule
import com.memebattle.memebattle.features.main.fragment.game.presentation.GameViewModel
import dagger.Subcomponent

@Subcomponent(modules = [GameSocketModule::class])
@FragmentScope
interface GameComponent {
    fun inject(gameViewModel: GameViewModel)

    @Subcomponent.Builder
    interface Builder {
        fun socketModule(gameSocketModule: GameSocketModule): Builder
        fun buid(): GameComponent
    }
}