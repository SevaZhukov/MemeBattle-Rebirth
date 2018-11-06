package com.memebattle.memebattle.features.main.fragment.rating.domain.util

import androidx.recyclerview.widget.DiffUtil
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.recycler.User

class UserDiffUtilCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}