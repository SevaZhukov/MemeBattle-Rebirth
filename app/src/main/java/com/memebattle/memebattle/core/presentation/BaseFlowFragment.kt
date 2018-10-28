package com.memebattle.memebattle.core.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.memebattle.R

abstract class BaseFlowFragment: Fragment() {

    lateinit var parentNavController: NavController
    lateinit var childNavController: NavController

    abstract fun setParentHost(): Int
    abstract fun setChildHost(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentNavController = Navigation.findNavController(activity!!, setParentHost())
        childNavController = Navigation.findNavController(activity!!, setChildHost())
    }
}