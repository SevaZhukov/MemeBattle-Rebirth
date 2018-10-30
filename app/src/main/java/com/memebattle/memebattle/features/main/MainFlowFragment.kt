package com.memebattle.memebattle.features.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import com.memebattle.memebattle.core.presentation.IOnBackPressed
import kotlinx.android.synthetic.main.flow_fragment_main.*
import kotlinx.android.synthetic.main.flow_fragment_main.view.*

class MainFlowFragment : BaseFragment(), IOnBackPressed {
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.flow_fragment_main, container, false)

        v.bottomNavigationView.setOnNavigationItemSelectedListener {
            //if (it.itemId != v.bottomNavigationView.selectedItemId) {
                when (it.itemId) {
                    R.id.profile -> {
                        navController.navigate(R.id.profileFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.settings -> {
                        navController.navigate(R.id.settingsFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.game -> {
                        navController.navigate(R.id.gameFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.news -> {
                        navController.navigate(R.id.newsFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                }
            //}
            false
        }
        return v
    }

    override fun onBackPressed(): Boolean {
        bottomNavigationView.menu.findItem(R.id.profile).isChecked = true
    }
}
