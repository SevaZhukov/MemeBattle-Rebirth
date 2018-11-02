package com.memebattle.memebattle.core.di.sub.main.sub.game.module

import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import com.memebattle.memebattle.features.main.fragment.game.domain.interactor.GameSocketService
import dagger.Module
import dagger.Provides

@Module
class GameSocketModule(var url: String) {

    @FragmentScope
    @Provides
    fun providesSocket(): Socket {
        return IO.socket(url)
    }

    @FragmentScope
    @Provides
    fun providesGameSocketService(socket: Socket): GameSocketService {
        return GameSocketService(socket)
    }
}