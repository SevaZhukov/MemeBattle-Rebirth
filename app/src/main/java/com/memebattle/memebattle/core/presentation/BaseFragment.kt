package com.memebattle.memebattle.core.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment: Fragment() {

    val TAG = "code"

    lateinit var navController: NavController
    lateinit var flowNavController: NavController

    abstract fun setHost(): Int
    abstract fun setFlowHost(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(activity!!, setHost())
        flowNavController = Navigation.findNavController(activity!!, setFlowHost())
    }

    fun showSnack(message: String) {
        Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT).show()
    }
}