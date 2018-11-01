package com.memebattle.memebattle.features.main.fragment.rating.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.memebattle.App
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.main.fragment.rating.domain.interactor.RatingApiService
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.req.RatingReq
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.Rating
import javax.inject.Inject

class RatingViewModel : ViewModel() {
    val TAG = "code"

    var users = MutableLiveData<Rating>()
    var error = MutableLiveData<String>()

    @Inject
    lateinit var apiService: RatingApiService

    init {
        App.instance.daggerComponentHelper.mainComponent!!.inject(this)
    }

    fun getRating() {
        val ratingReq = RatingReq("")
        apiService.getRating(ratingReq, object : BaseCallback<Rating> {
            override fun onSuccess(data: Rating?) {
                users.value = data
            }

            override fun onError(t: Throwable) {
                error.value = t.message
            }
        })
    }
}