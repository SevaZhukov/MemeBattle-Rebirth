package com.memebattle.memebattle.features.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.flow_fragment_main, container, false)
        v.bottomNavigationView.setOnNavigationItemSelectedListener {
            if (it.itemId != v.bottomNavigationView.selectedItemId) {
                when (it.itemId) {
                    R.id.profile -> {
                        navController.navigate(R.id.profileFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.settings -> {
                        navController.navigate(R.id.settingsFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                }
            }
            false
        }
        return v
    }
}
