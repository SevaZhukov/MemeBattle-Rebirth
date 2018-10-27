package com.memebattle.memebattle.features.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFlowFragment
import kotlinx.android.synthetic.main.flow_fragment_main.view.*

class MainFlowFragment : BaseFlowFragment() {
    override fun setParentHost(): Int {
        return R.id.nav_host
    }

    override fun setChildHost(): Int {
        return R.id.flow_host_main
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.flow_fragment_main, container, false)
        v.bottomNavigationView.setOnNavigationItemSelectedListener {
            if (it.itemId != v.bottomNavigationView.selectedItemId) {
                when (it.itemId) {
                    R.id.profile -> {
                        childNavController.navigate(R.id.profileFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.settings -> {
                        childNavController.navigate(R.id.settingsFragment)
                        return@setOnNavigationItemSelectedListener true
                    }
                }
            }
            false
        }
        return v
    }
}
