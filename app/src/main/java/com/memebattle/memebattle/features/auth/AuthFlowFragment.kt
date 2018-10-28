package com.memebattle.memebattle.features.auth


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.memebattle.App
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "oncreate flow")
        App.instance.plusAuthComponent()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "ondestroyview flow")
        App.instance.removeAuthComponent()
    }
}
