package com.memebattle.memebattle.features.main.fragment.game


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment

class GameFragment : BaseFragment() {
    override fun setHost(): Int {
        return R.id.flow_host_main
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_game, container, false)
        return v
    }
}
