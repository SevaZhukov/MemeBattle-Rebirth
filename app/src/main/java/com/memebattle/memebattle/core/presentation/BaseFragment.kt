package com.memebattle.memebattle.core.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseFragment: Fragment() {

    lateinit var navController: NavController

    abstract fun setHost(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(activity!!, setHost())
    }
}