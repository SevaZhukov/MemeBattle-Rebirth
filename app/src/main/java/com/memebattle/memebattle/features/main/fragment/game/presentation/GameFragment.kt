package com.memebattle.memebattle.features.main.fragment.game.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.memebattle.memebattle.App
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import com.memebattle.memebattle.features.main.fragment.game.domain.events.GameSendEvent
import kotlinx.android.synthetic.main.fragment_game.view.*

class GameFragment : BaseFragment() {
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
        viewModel.memes.observe(this, Observer {

        })
        v.gameButton.setOnClickListener {
            val map = hashMapOf(Pair("lol", "kek"))
            viewModel.emitMessage(GameSendEvent.RESULT, map)
        }
        return v
    }
}
