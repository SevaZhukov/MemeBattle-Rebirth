package com.memebattle.memebattle.features.auth


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memebattle.memebattle.App
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment

class AuthFlowFragment : BaseFragment() {
    override fun setHost(): Int {
        return R.id.flow_host_auth
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.flow_fragment_auth, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.daggerComponentHelper.plusAuthComponent()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.daggerComponentHelper.removeAuthComponent()
    }
}
