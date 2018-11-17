package com.memebattle.memebattle.features.main.fragment.rating.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.memebattle.memebattle.core.domain.MainThreadExecutor
import com.memebattle.memebattle.features.main.fragment.rating.data.paging.RatingPositionalDataSource
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User
import java.util.concurrent.Executors

class RatingViewModel : ViewModel() {

    var error = MutableLiveData<String>()
    var pagedList = MutableLiveData<PagedList<User>>()

    fun getRating() {
        val positionalDataSource = RatingPositionalDataSource(error)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(8)
                .build()
        pagedList.value = PagedList.Builder(positionalDataSource, config)
                .setNotifyExecutor(MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build()
    }
}