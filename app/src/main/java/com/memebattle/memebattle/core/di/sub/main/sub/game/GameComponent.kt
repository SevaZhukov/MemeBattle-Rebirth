package com.memebattle.memebattle.core.di.sub.main.sub.game

import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.core.di.sub.main.sub.game.module.GameApiModule
import com.memebattle.memebattle.core.di.sub.main.sub.game.module.GameSocketModule
import dagger.Subcomponent

@Subcomponent(modules = [GameApiModule::class])
@FragmentScope
interface GameComponent {

    @Subcomponent.Builder
    interface Builder {
        fun apiModule(gameApiModule: GameApiModule): Builder
        fun socketModule(gameSocketModule: GameSocketModule): Builder
        fun buid(): GameComponent
    }
}