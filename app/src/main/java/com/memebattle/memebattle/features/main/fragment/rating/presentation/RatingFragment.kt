package com.memebattle.memebattle.features.main.fragment.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import com.memebattle.memebattle.features.main.fragment.rating.domain.util.UserDiffUtilCallback
import com.memebattle.memebattle.features.main.fragment.rating.presentation.RatingViewModel
import com.memebattle.memebattle.features.main.fragment.rating.presentation.recycler.RatingAdapter
import kotlinx.android.synthetic.main.fragment_rating.*

class RatingFragment : BaseFragment() {
    override fun setHost(): Int {
        return R.id.flow_host_main
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    lateinit var viewModel: RatingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_rating, container, false)
        viewModel = ViewModelProviders.of(this).get(RatingViewModel::class.java)
        viewModel.pagedList.observe(this, Observer {
            val adapter = RatingAdapter(UserDiffUtilCallback())
            adapter.submitList(it)
            recyclerView.adapter = adapter
        })
        viewModel.getRating()
        return v
    }
}
