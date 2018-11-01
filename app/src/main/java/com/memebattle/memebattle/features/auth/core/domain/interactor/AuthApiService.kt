package com.memebattle.memebattle.features.auth.core.domain.interactor

import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.auth.core.data.ApiAuth
import com.memebattle.memebattle.features.auth.core.domain.model.req.UserReq
import com.memebattle.memebattle.features.auth.core.domain.model.req.VkCode
import com.memebattle.memebattle.features.auth.core.domain.model.res.UserRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthApiService(var api: ApiAuth) {
    fun signIn(name: String, callback: BaseCallback<UserRes>) {
        api.signIn(UserReq(name)).enqueue(object : Callback<UserRes> {
            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                callback.onSuccess(response.body())
            }

            override fun onFailure(call: Call<UserRes>, t: Throwable) {
                callback.onError(t)
            }
        })
    }

    fun signUp(name: String, callback: BaseCallback<UserRes>) {
        api.signUp(UserReq(name)).enqueue(object : Callback<UserRes> {
            override fun onFailure(call: Call<UserRes>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                callback.onSuccess(response.body()!!)
            }

        })
    }

    fun authVk(code: String, callback: BaseCallback<UserRes>) {
        api.vkAuth(VkCode(code)).enqueue(object : Callback<UserRes> {
            override fun onFailure(call: Call<UserRes>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                callback.onSuccess(response.body()!!)
            }

        })
    }
}