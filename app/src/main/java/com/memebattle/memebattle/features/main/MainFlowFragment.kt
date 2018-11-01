package com.memebattle.memebattle.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.NavigationUI
import com.memebattle.memebattle.App
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import kotlinx.android.synthetic.main.flow_fragment_main.*

class MainFlowFragment : BaseFragment() {
    override fun setHost(): Int {
        return R.id.flow_host_main
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.daggerComponentHelper.plusMainComponent()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.daggerComponentHelper.removeMainComponent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.flow_fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}
