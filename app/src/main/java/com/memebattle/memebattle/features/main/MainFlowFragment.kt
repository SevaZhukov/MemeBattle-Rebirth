package com.memebattle.memebattle.features.main


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavGraph
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import kotlinx.android.synthetic.main.flow_fragment_main.view.*

class MainFlowFragment : BaseFragment() {
    override fun setHost(): Int {
        return R.id.flow_host_main
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    val NEWS = "news"
    val SETTINGS = "settings"
    val PROFILE = "profile"
    val GAME = "game"

    var curGraph = NEWS
    val graphs = hashMapOf<String, NavGraph>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.flow_fragment_main, container, false)
        v.bottomNavigationView.setOnNavigationItemSelectedListener {
            if (it.itemId != v.bottomNavigationView.selectedItemId) {
                when (it.itemId) {
                    R.id.profile -> {
                        curGraph = PROFILE
                        navController.navigate(R.id.profileFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.settings -> {
                        curGraph = SETTINGS
                        navController.navigate(R.id.settingsFragment)
                        getGraph()
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.game -> {
                        curGraph = GAME
                        navController.navigate(R.id.gameFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.news -> {
                        curGraph = NEWS
                        navController.navigate(R.id.newsFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                }
            }
            false
        }
        return v
    }

    fun getGraph() {
        navController.graph.forEach {
            Log.i(TAG, "graph foreach ${it.label}")
        }
        navController.graph.clear()
        navController.graph.forEach {
            Log.i(TAG, "graph after foreach ${it.label}")
        }
        navController.graph
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
