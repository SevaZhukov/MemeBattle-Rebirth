package com.memebattle.memebattle.features.auth.fragment.sign_up


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import com.memebattle.memebattle.features.auth.fragment.sign_in.SignInViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUpFragment : BaseFragment() {

    lateinit var viewModel: SignUpViewModel

    override fun setHost(): Int {
        return R.id.flow_host_auth
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sign_up, container, false)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        v.backButton.setOnClickListener {
            navController.popBackStack()
        }
        v.mainButton.setOnClickListener {
            flowNavController.navigate(R.id.action_authFlowFragment_to_mainFlowFragment)
        }
        return v
    }
}
