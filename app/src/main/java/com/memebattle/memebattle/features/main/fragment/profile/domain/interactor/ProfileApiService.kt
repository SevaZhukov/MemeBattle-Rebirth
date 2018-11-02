package com.memebattle.memebattle.features.main.fragment.profile.domain.interactor

import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.main.fragment.profile.data.ApiProfile
import com.memebattle.memebattle.features.main.fragment.profile.domain.model.req.ProfileReq
import com.memebattle.memebattle.features.main.fragment.profile.domain.model.res.Profile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileApiService(var api: ApiProfile) {
    fun getProfile(profileReq: ProfileReq, callback: BaseCallback<Profile>) {
        api.getProfile(profileReq)
                .enqueue(object : Callback<Profile> {
                    override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                        callback.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<Profile>, t: Throwable) {
                        callback.onError(t)
                    }
                })
    }
}