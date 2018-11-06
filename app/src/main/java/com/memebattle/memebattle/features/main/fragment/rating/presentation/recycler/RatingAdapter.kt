package com.memebattle.memebattle.features.main.fragment.rating.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseViewHolder
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User
import com.memebattle.memebattle.features.main.fragment.rating.domain.util.UserDiffUtilCallback

class RatingAdapter(diffUtilCallback: UserDiffUtilCallback) : PagedListAdapter<User, BaseViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rating, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val user = getItem(position)
        //set view
    }
}