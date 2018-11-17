package com.memebattle.memebattle.features.main.fragment.rating.domain.interactor

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.memebattle.memebattle.features.main.fragment.rating.data.api.ApiRating
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.Rating
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RatingApiService(var api: ApiRating) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<User>, error: MutableLiveData<String>) {
        api.getRating(params.startPosition.toString(), params.loadSize.toString())
                .enqueue(object : Callback<Rating> {
                    override fun onResponse(call: Call<Rating>, response: Response<Rating>) {
                        callback.onResult(response.body()!!.list)
                    }

                    override fun onFailure(call: Call<Rating>, t: Throwable) {
                        error.value = t.message
                    }
                })
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<User>, error: MutableLiveData<String>) {
        api.getRating("0", params.pageSize.toString())
                .enqueue(object : Callback<Rating> {
                    override fun onResponse(call: Call<Rating>, response: Response<Rating>) {
                        callback.onResult(response.body()!!.list, 0)
                    }

                    override fun onFailure(call: Call<Rating>, t: Throwable) {
                        error.value = t.message
                    }
                })
    }
}