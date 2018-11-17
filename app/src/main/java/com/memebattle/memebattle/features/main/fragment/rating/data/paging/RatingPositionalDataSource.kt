package com.memebattle.memebattle.features.main.fragment.rating.data.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.memebattle.memebattle.App
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingApiService
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User
import com.memebattle.memebattle.features.main.fragment.rating.domain.repository.RatingRepository
import javax.inject.Inject

class RatingPositionalDataSource(val error: MutableLiveData<String>) : PositionalDataSource<User>() {

    init {
        App.instance.daggerComponentHelper.ratingComponent!!.inject(this)
    }

    @Inject
    lateinit var apiService: RatingApiService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<User>) {
        apiService.loadRange(params, callback, error)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<User>) {
        apiService.loadInit(params, callback, error)
    }
}