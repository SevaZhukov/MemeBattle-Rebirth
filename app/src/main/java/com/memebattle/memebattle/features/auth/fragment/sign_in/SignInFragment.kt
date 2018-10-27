package com.memebattle.memebattle.features.auth.fragment.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

class SignInFragment : BaseFragment() {

    override fun setHost(): Int {
        return R.id.flow_host_auth
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sign_in, container, false)
        v.gotoSignUpButton.setOnClickListener {
            navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        return v
    }
}
