package com.memebattle.memebattle.features.main.fragment.rating.domain.interactor

import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.main.fragment.rating.data.ApiRating
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.req.RatingReq
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.Rating
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RatingApiService(var api: ApiRating) {
    fun getRating(ratingReq: RatingReq, callback: BaseCallback<Rating>) {
        api.getRating(ratingReq)
                .enqueue(object : Callback<Rating> {
                    override fun onResponse(call: Call<Rating>, response: Response<Rating>) {
                        callback.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<Rating>, t: Throwable) {
                        callback.onError(t)
                    }
                })
    }
}