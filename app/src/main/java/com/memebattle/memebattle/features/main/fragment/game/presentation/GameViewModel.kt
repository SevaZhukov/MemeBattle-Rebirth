package com.memebattle.memebattle.features.main.fragment.game.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.App
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameEvent
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameSendEvent
import com.memebattle.memebattle.features.main.fragment.game.domain.interactor.GameSocketService
import com.memebattle.memebattle.features.main.fragment.game.domain.model.Memes
import com.memebattle.memebattle.features.main.fragment.game.domain.model.Result
import org.json.JSONObject
import javax.inject.Inject

class GameViewModel : ViewModel() {
    val TAG = "code"

    var memes = MutableLiveData<Memes>()
    var result = MutableLiveData<Result>()

    @Inject
    lateinit var socketService: GameSocketService

    init {
        App.instance.daggerComponentHelper.gameComponent!!.inject(this)

        socketService.setOnMemes(memes)
        socketService.setOnResult(result)
        socketService.connect()
    }

    fun emitMessage(event: GameSendEvent, map: HashMap<String, String>) {
        socketService.emit(event, map)
    }
}