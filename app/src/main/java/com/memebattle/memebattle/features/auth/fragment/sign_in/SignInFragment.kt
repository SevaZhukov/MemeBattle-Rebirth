package com.memebattle.memebattle.features.auth.fragment.sign_in

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

class SignInFragment : BaseFragment() {

    lateinit var viewModel: SignInViewModel

    override fun setHost(): Int {
        return R.id.flow_host_auth
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sign_in, container, false)
        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        viewModel.user.observe(this, Observer {
            Log.i(TAG, "user observe $it")
            navController.navigate(R.id.action_signInFragment_to_mainFlowFragment2)
        })
        viewModel.error.observe(this, Observer {
            Log.i(TAG, "error observe $it")
            showSnack(it)
        })
        v.gotoSignUpButton.setOnClickListener {
            //navController.navigate(R.id.action_signInFragment_to_signUpFragment)
            viewModel.getId()
        }
        v.signInButton.setOnClickListener {
            viewModel.signIn("")
        }
        return v
    }
}
