package com.memebattle.memebattle.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.IOnBackPressed

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onBackPressed() {
        val fragment = navController.currentDestination
        if ((fragment as? IOnBackPressed)?.onBackPressed()!!.not()) {
            super.onBackPressed()
        }
    }
}
