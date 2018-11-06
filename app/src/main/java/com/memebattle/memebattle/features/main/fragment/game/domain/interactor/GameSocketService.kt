package com.memebattle.memebattle.features.main.fragment.game.domain.interactor

import androidx.lifecycle.MutableLiveData
import com.github.nkzawa.socketio.client.Socket
import com.google.gson.Gson
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameEvent
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameSendEvent
import com.memebattle.memebattle.features.main.fragment.game.domain.model.Memes
import com.memebattle.memebattle.features.main.fragment.game.domain.model.Result
import org.json.JSONObject

class GameSocketService(private val socket: Socket) {

    fun connect() {
        socket.connect()
    }

    fun setOnEvent(event: GameEvent, liveData: MutableLiveData<JSONObject>) {
        socket.on(event.name) {
            liveData.value = it[0] as JSONObject
        }
    }

    fun setOnMemes(memes: MutableLiveData<Memes>) {
        socket.on(GameEvent.MEME.name) {
            val obj = it[0] as JSONObject
        }
    }

    fun setOnResult(result: MutableLiveData<Result>) {
        socket.on(GameEvent.MEME.name) {
            val obj = it[0] as JSONObject
            val gson = Gson()
            result.value = gson.fromJson(obj.toString(), Result::class.java)
        }
    }

    fun emit(event: GameSendEvent, map: HashMap<String, String>) {
        socket.emit(event.name, makeMessage(map))
    }

    private fun makeMessage(map: HashMap<String, String>): JSONObject {
        val jsonObject = JSONObject()
        map.forEach {
            jsonObject.put(it.key, it.value)
        }
        return jsonObject
    }
}