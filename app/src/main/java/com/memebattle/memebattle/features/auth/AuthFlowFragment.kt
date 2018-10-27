package com.memebattle.memebattle.features.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFlowFragment
import com.memebattle.memebattle.core.presentation.BaseFragment

class AuthFlowFragment : BaseFlowFragment() {

    override fun setParentHost(): Int {
        return R.id.nav_host
    }

    override fun setChildHost(): Int {
        return R.id.flow_host_auth
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.flow_fragment_auth, container, false)
    }
}
