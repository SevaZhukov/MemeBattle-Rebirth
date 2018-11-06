package com.memebattle.memebattle.features.main.fragment.game.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.memebattle.memebattle.App
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameEvent
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameSendEvent
import com.memebattle.memebattle.features.main.fragment.game.domain.model.Memes
import com.memebattle.memebattle.features.main.fragment.game.domain.model.Result
import kotlinx.android.synthetic.main.fragment_game.view.*
import org.json.JSONObject

class GameFragment : BaseFragment() {
    val gson = Gson()

    override fun setHost(): Int {
        return R.id.flow_host_main
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.daggerComponentHelper.plusGameComponent()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.daggerComponentHelper.removeGameComponent()
    }

    lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_game, container, false)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        /*viewModel.memes.observe(this, Observer {

        })
        viewModel.result.observe(this, Observer {

        })*/
        viewModel.message.observe(this, Observer {
            when (it.getString("type")) {
                GameEvent.MEME.name -> {
                    val memes = gson.fromJson(it.toString(), Memes::class.java)
                }
                GameEvent.RESULT.name -> {
                    val results = gson.fromJson(it.toString(), Result::class.java)
                }
            }
        })
        v.gameButton.setOnClickListener {
            val map = hashMapOf(Pair("lol", "kek"))
            viewModel.emitMessage(GameSendEvent.RESULT, map)
        }
        return v
    }
}
